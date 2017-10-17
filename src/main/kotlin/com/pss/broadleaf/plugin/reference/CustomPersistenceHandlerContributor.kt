package com.pss.broadleaf.plugin.reference

import com.intellij.patterns.PsiJavaPatterns.*
import com.intellij.patterns.PsiMethodPattern
import com.intellij.psi.*
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.psi.search.searches.MethodReferencesSearch
import com.intellij.psi.util.*
import com.intellij.util.ProcessingContext
import com.pss.broadleaf.plugin.BroadleafConstants.FrameworkTypes
import com.pss.broadleaf.plugin.*
import com.siyeh.ig.psiutils.TypeUtils

class CustomPersistenceHandlerContributor : PsiReferenceContributor(){


    companion object {

        val MATCHER = psiElement()
                .methodCallParameter(psiMethod().withName("get").definedInClass("java.util.Map"))
                .inside(psiClass().inheritorOf(true, FrameworkTypes.CUSTOM_PERSISTENCE_HANDLER))
        val TRY_INFER_TYPE = psiMethod()
                .withName("canHandleAdd")

        val HAS_COMMENT = Regex("@type")
        val CAN_HANDLE_METHOD_MATCH = mutableMapOf<String, PsiMethodPattern>(
                Pair("add", psiMethod().withName("canHandleAdd").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE)),
                Pair("remove", psiMethod().withName("canHandleRemove").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE)),
                Pair("inspect", psiMethod().withName("canHandleInspect").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE)),
                Pair("update", psiMethod().withName("canHandleUpdate").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE))
        )
        val FIELD_MATCHER = psiField().withoutModifiers(PsiModifier.STATIC)
        val HANDLER_METHODS_MATCH = or(
                psiMethod().withName("inspect").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE, FrameworkTypes.DYNAMIC_ENTITY_DAO, FrameworkTypes.INSPECT_HELPER),
                psiMethod().withName("fetch").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE, FrameworkTypes.CRITERIA_TRANSFER_OBJECT, FrameworkTypes.DYNAMIC_ENTITY_DAO, FrameworkTypes.RECORD_HELPER),
                psiMethod().withName("add").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE, FrameworkTypes.DYNAMIC_ENTITY_DAO, FrameworkTypes.RECORD_HELPER),
                psiMethod().withName("remove").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE, FrameworkTypes.DYNAMIC_ENTITY_DAO, FrameworkTypes.RECORD_HELPER),
                psiMethod().withName("update").withParameters(FrameworkTypes.PERSISTENCE_PACKAGE, FrameworkTypes.DYNAMIC_ENTITY_DAO, FrameworkTypes.RECORD_HELPER)
        )

        val PARSE_COMMENT = Regex("//\\s*@type\\s*=\\s*(.+)").toPattern()
    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(MATCHER, PersistenceProvider())
    }




    class PersistenceProvider : PsiReferenceProvider(){
        override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            if(element is PsiLiteralExpression && isFieldMetadataMap(element)){
                getComment(element)?.let {
                    val parsed = PARSE_COMMENT.matcher(it.text)

                    if(parsed.matches() && parsed.group(1).isNotEmpty()){
                        JavaPsiFacade.getInstance(element.project).findClass(parsed.group(1), element.resolveScope)?.let {
                            // Returns Method
                            return@getReferencesByElement ClassInheritorsSearch.search(it).findAll()
                                    .map { References(it, element) }
                                    .toTypedArray()
                        }
                    }
                }
                element.findParent(PsiMethod::class.java)?.let { method->
                    if(CAN_HANDLE_METHOD_MATCH.containsKey(method.name)) {
                        CAN_HANDLE_METHOD_MATCH.getValue(method.name)?.let { methodPattern ->
                            element.findParent(PsiClass::class.java)?.let { containingClass ->
                                containingClass.methods.find { methodPattern.accepts(it) }?.let {
                                    tryToGetType(it)?.let {
                                        return@getReferencesByElement it.getInheritorsWithThis().map { References(it, element) }.toTypedArray()
                                    }
                                }
                            }
                        }
                    } else {
                        val reference = MethodReferencesSearch.search(method).findAll()
                        if(reference.isEmpty()){

                        } else {
                            element.findParent(PsiClass::class.java)?.let { type ->
                                val methods = reference.mapNotNull { it.element.findParent(PsiMethod::class.java) }
                                        .filter { it.containingClass ==  type}
                                        .filter { HANDLER_METHODS_MATCH.accepts(it) }
                                if(methods.size == 1){
                                    methods.first().let {
                                        it.containingClass?.findMethodsByName("canHandle${it.name.first().toUpperCase()}${it.name.substring(1)}", false)?.let {
                                            if(it.size == 1){
                                                tryToGetType(it.first())?.let {
                                                    return@getReferencesByElement it.getInheritorsWithThis().map { References(it, element) }.toTypedArray()
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }

                }

            }
            return PsiReference.EMPTY_ARRAY
        }

        private fun tryToGetType(method: PsiMethod): PsiClass? {
            val found = PsiTreeUtil.findChildrenOfType(method, PsiMethodCallExpression::class.java)
            if (found.isNotEmpty()) {
                val filtered = found.filter {
                    it.firstChild is PsiReferenceExpression &&
                            (it.firstChild as PsiReferenceExpression).qualifiedName == "isAssignableFrom"
                }
                if (!(filtered.size > 1 || filtered.isEmpty())) {
                    filtered.first().let {
                        if (it.argumentList.expressions.size == 2) {
                            val secondArgument = it.argumentList.expressions[1]
                            if (secondArgument is PsiClassObjectAccessExpression) {
                                val type = secondArgument.operand
                                return@tryToGetType PsiUtil.resolveClassInClassTypeOnly(type.type.deepComponentType)
                            }
                        }
                    }
                }
            }
            return null
        }

        private fun isFieldMetadataMap(element: PsiLiteralExpression): Boolean {
            element.findParent(PsiMethodCallExpression::class.java)?.let { methodCallExpression ->
                val psiReferenceExpression = methodCallExpression.firstChild
                if (psiReferenceExpression is PsiReferenceExpression) {
                    val psiFacade = element.javaPsiFacade()
                    val mapPsiClass = psiFacade.findClass(CommonClassNames.JAVA_UTIL_MAP, element.resolveScope)
                    val stringPsiType = TypeUtils.getType(CommonClassNames.JAVA_LANG_STRING, element)
                    val fieldMetadataPsiType = TypeUtils.getType(BroadleafConstants.FrameworkTypes.FIELD_METADATA, element)
                    mapPsiClass?.typeParameters?.let { typeParams ->
                        val javaResolveResult = psiReferenceExpression.advancedResolve(false)
                        val substitutor = javaResolveResult.substitutor
                        val key = substitutor.substitute(typeParams.first())
                        val value = substitutor.substitute(typeParams.second())
                        if (key?.isAssignableFrom(stringPsiType) == true && value?.isAssignableFrom(fieldMetadataPsiType) == true) {
                            return@isFieldMetadataMap true
                        }
                    }


                }
            }
            return false
        }

        @Suppress("SENSELESS_COMPARISON")
        fun getComment(methodCallExpression: PsiLiteralExpression): PsiComment? {
            var parent = methodCallExpression.parent
            while(parent != null && parent !is PsiMethod) {
                if (parent != null) {
                    val comment = parent.children.find { it is PsiComment && it.text.contains(HAS_COMMENT) }
                    if (comment == null) {
                        parent = parent.parent
                    } else {
                        return comment as PsiComment
                    }
                }
            }
            return null
        }


    }



    class References(val context: PsiClass, myElement:  PsiLiteralExpression) : PsiReferenceBase<PsiLiteralExpression>(myElement, false) {
        override fun resolve(): PsiElement? {
            if(element.value is String) {
                return context.findFieldByName(element.value as String, true)
            }
            return null;
        }

        override fun bindToElement(element: PsiElement): PsiElement {
            if(element is PsiField){
                return handleElementRename(element.name)
            }
            return super.bindToElement(element)
        }

        override fun getVariants(): Array<Any> {
            return context.allFields.filter { FIELD_MATCHER.accepts(it) }.map {it.name}.toTypedArray() as Array<Any>
        }
    }

}