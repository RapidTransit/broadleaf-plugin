package com.pss.broadleaf.plugin.reference

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import com.intellij.util.containers.filterSmart
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection as Adorned
import com.pss.broadleaf.plugin.doWithAnnotation
import com.pss.broadleaf.plugin.getFields

import com.pss.broadleaf.plugin.reduceFields

class GridVisibleFieldsReferenceProvider : BaseFieldReferenceProvider(){

    companion object {
        val LOG = Logger.getInstance(GridVisibleFieldsReferenceProvider::class.java)
    }
    override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        val type = field.type
        var searchFields = false
        var split : MutableList<String> = mutableListOf()
        if(element is PsiLiteralExpression){
            val value = element.value as String
            if(value.contains(".")){
                 split = StringUtil.split(value, ".")
                 searchFields = true
            }
        }
        val psiClassList = mutableListOf<PsiClass>()
        if(type is PsiClassType && type.hasParameters()){
            val parameter = type.parameters.first()
            if(parameter is PsiClassType){
                 parameter.resolve()?.let {
                     findConcrete(it).toCollection(psiClassList)
                }

                field.doWithAnnotation(Adorned.CLASS_NAME_SET, { _, psiAnnotation ->
                    AnnotationUtil.findDeclaredAttribute(psiAnnotation, Adorned.TARGET_OBJECT_PROPERTY)?.let {
                        it.literalValue?.let {
                            parameter.getFields(it).forEach {
                                val type = it.type
                                if(type is PsiClassType) {
                                    type.resolve()?.let{
                                        findConcrete(it).toCollection(psiClassList)
                                    }

                                }
                            }
                        }
                    }
                })
            }
        }
        var list = mutableListOf<PsiClass>()
        if(searchFields) {
            val dropped = split.dropLast(1)

            list.addAll(psiClassList)
            for(fieldName in dropped){
                list = list.reduceFields(fieldName)
            }
            return list.map { References(it, element as PsiLiteralExpression, split.last(), split.dropLast(1).toMutableList() ) }.toTypedArray()
        } else {
            list = psiClassList
            return list.map { References(it, element as PsiLiteralExpression, element.value as String) }.toTypedArray()
        }

    }
}