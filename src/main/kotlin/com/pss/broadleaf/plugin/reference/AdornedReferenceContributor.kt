package com.pss.broadleaf.plugin.reference

import com.intellij.openapi.diagnostic.Logger
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PsiJavaPatterns
import com.intellij.psi.*
import com.intellij.psi.search.searches.ClassInheritorsSearch

import com.intellij.util.ProcessingContext

class AdornedReferenceContributor : PsiReferenceContributor() {

    companion object {
        val LOG : Logger  = Logger.getInstance(AdornedReferenceContributor::class.java);
        val TARGET_OBJ_PROP = "targetObjectProperty"
        val ANNOTATION: ElementPattern<out PsiElement> = PsiJavaPatterns.psiLiteral()
                .annotationParam("org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection", TARGET_OBJ_PROP)


    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(ANNOTATION, AnnotationReferenceProvider())
    }

    class AnnotationReferenceProvider : PsiReferenceProvider(){
        override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            var field : PsiField? = null;
            var parent = element;
            while(field == null){
                if(parent != null){
                    parent = parent.parent
                    if(parent is PsiField){
                        field = parent
                        break
                    }
                } else {
                    return PsiReference.EMPTY_ARRAY
                }
            }

            if(field != null){
                val type = field.type
                if(type is PsiClassType && type.hasParameters()){
                    val parameter = type.parameters.first()
                    if(parameter is PsiClassType){
                        val paramaterClass = parameter.resolve()
                        if(paramaterClass != null){
                            val fields : List<PsiReference>;
                            if(paramaterClass.isInterface){
                                fields = ClassInheritorsSearch.search(paramaterClass).findAll().filter { !it.isInterface }
                                        .map { References(it, element as PsiLiteralExpression) }
                            } else {
                                fields = arrayListOf(References(paramaterClass, element as PsiLiteralExpression))
                            }
                            return fields.toTypedArray();
                        }
                    }
                }
            }
            return PsiReference.EMPTY_ARRAY
        }
    }

    class References(val context: PsiClass, myElement:  PsiLiteralExpression) : PsiReferenceBase<PsiLiteralExpression>(myElement, false) {
        override fun resolve(): PsiElement? {
//            PsiPolyVariantReference
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
            return context.allFields.map { it.name}.toTypedArray() as Array<Any>
        }
    }
}