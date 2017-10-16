package com.pss.broadleaf.plugin.reference

import com.intellij.patterns.PsiJavaPatterns.*
import com.intellij.psi.*
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.psi.stubsHierarchy.ClassHierarchy
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.PsiUtil
import com.intellij.spring.model.utils.PsiTypeUtil
import com.intellij.util.ProcessingContext
import com.intellij.util.containers.isNullOrEmpty
import com.pss.broadleaf.plugin.BroadleafConstants
import com.pss.broadleaf.plugin.findParent
import com.pss.broadleaf.plugin.getInheritorsWithThis
import com.siyeh.ig.psiutils.CollectionUtils
import org.jetbrains.uast.getUastParentOfType

class CustomPersistenceHandlerContributor : PsiReferenceContributor(){

    companion object {
        val MATCHER = psiElement()
                .methodCallParameter(psiMethod().withName("get").definedInClass("java.util.Map"))
                .inside(psiClass().inheritorOf(true, BroadleafConstants.FrameworkTypes.CUSTOM_PERSISTENCE_HANDLER))
        val TRY_INFER_TYPE = psiMethod()
                .withName("canHandleAdd")

        val HAS_COMMENT = Regex("@type")
        val PARSE_COMMENT = Regex("//\\s*@type\\s*=\\s*(.+)").toPattern()
    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(MATCHER, PersistenceProvider())
    }

    class MethodVisitor : JavaElementVisitor(){
        var result: PsiClass? = null
        override fun visitMethod(method: PsiMethod?) {
            if(method != null && TRY_INFER_TYPE.accepts(method)){
                val found = PsiTreeUtil.findChildrenOfType(method, PsiMethodCallExpression::class.java)
                  if(found.isNotEmpty()){
                      val filtered = found.filter {
                          it.firstChild is PsiReferenceExpression &&
                              (it.firstChild as PsiReferenceExpression).qualifiedName == "isAssignableFrom" }
                      if(!(filtered.size > 1 || filtered.isEmpty())){
                          filtered.first().let {
                              if(it.argumentList.expressions.size == 2){
                                  val secondArgument = it.argumentList.expressions[1]
                                  if(secondArgument is PsiClassObjectAccessExpression){
                                      val type = secondArgument.operand
                                      this.result = PsiUtil.resolveClassInClassTypeOnly(type.type.deepComponentType)
                                  }
                              }
                          }
                      }
                  }
            }
        }
    }


    class PersistenceProvider : PsiReferenceProvider(){
        override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            if(element is PsiLiteralExpression){
                element.findParent(PsiClass::class.java)?.let {
                    val visitor = MethodVisitor()
                    it.acceptChildren(visitor)
                    visitor.result?.let {
                        return@getReferencesByElement it.getInheritorsWithThis().map { References(it, element) }.toTypedArray()
                    }
                }
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
            }
            return PsiReference.EMPTY_ARRAY
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
            return context.allFields.map {it.name}.toTypedArray() as Array<Any>
        }
    }

}