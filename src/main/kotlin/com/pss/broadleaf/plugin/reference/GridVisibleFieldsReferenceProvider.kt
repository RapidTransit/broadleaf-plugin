package com.pss.broadleaf.plugin.reference

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import com.pss.broadleaf.plugin.BroadleafConstants
import com.pss.broadleaf.plugin.doWithAnnotation
import com.pss.broadleaf.plugin.getFields

class GridVisibleFieldsReferenceProvider : BaseFieldReferenceProvider(){
    companion object {
        val LOG = Logger.getInstance(GridVisibleFieldsReferenceProvider::class.java)
    }
    override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        val type = field.type

        val list = mutableListOf<References>()
        if(type is PsiClassType && type.hasParameters()){
            val parameter = type.parameters.first()
            if(parameter is PsiClassType){

                 parameter.resolve()?.let {
                     findConcrete(it).forEach{ list.add(References(it, element as PsiLiteralExpression)) }
                }

                field.doWithAnnotation(BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection.CLASS_NAME_SET, { psiField, psiAnnotation ->
                    AnnotationUtil.findDeclaredAttribute(psiAnnotation, BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection.TARGET_OBJECT_PROPERTY)?.let {
                        it.literalValue?.let {
                            parameter.getFields(it).forEach {
                                val type = it.type
                                if(type is PsiClassType) {
                                    type.resolve()?.let{
                                        findConcrete(it).forEach { list.add(References(it, element as PsiLiteralExpression)) }
                                    }

                                }
                            }
                        }
                    }
                })
            }
        }


        return list.toTypedArray()
    }
}