package com.pss.broadleaf.plugin.reference

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import com.intellij.util.containers.filterSmart
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection as Adorned
import com.pss.broadleaf.plugin.doWithAnnotation
import com.pss.broadleaf.plugin.getAdornedPsiClasses
import com.pss.broadleaf.plugin.getFields

import com.pss.broadleaf.plugin.reduceFields

class GridVisibleFieldsReferenceProvider : BaseFieldReferenceProvider(){

    companion object {
        val LOG = Logger.getInstance(GridVisibleFieldsReferenceProvider::class.java)
    }
    override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {

        if(element is PsiLiteralExpression){
            val adornedClasses = field.getAdornedPsiClasses()
            val value = element.value as String
            var list = mutableListOf<PsiClass>()
            if(value.contains(".")){
                val split = StringUtil.split(value, ".")
                val dropped = split.dropLast(1)
                val last = split.last()
                list.addAll(adornedClasses)
                for(fieldName in dropped){
                    list = list.reduceFields(fieldName)
                }
                return list.map { PropertyPathReference(element, it, dropped, last) }.toTypedArray()
            } else {
                list.addAll(adornedClasses)
                return list.map { SimplePathReference( element, it, value) }.toTypedArray()
            }
        }
        return PsiReference.EMPTY_ARRAY
//        val psiClassList = mutableListOf<PsiClass>()
//        if(type is PsiClassType && type.hasParameters()){
//            val parameter = type.parameters.first()
//            if(parameter is PsiClassType){
//                 parameter.resolve()?.let {
//                     findConcrete(it).toCollection(psiClassList)
//                }
//
//                field.doWithAnnotation(Adorned.CLASS_NAME_SET, { _, psiAnnotation ->
//                    AnnotationUtil.findDeclaredAttribute(psiAnnotation, Adorned.TARGET_OBJECT_PROPERTY)?.let {
//                        it.literalValue?.let {
//                            parameter.getFields(it).forEach {
//                                val type = it.type
//                                if(type is PsiClassType) {
//                                    type.resolve()?.let{
//                                        findConcrete(it).toCollection(psiClassList)
//                                    }
//
//                                }
//                            }
//                        }
//                    }
//                })
//            }
//        }


    }
}