package com.pss.broadleaf.plugin.reference

import com.intellij.psi.*
import com.intellij.util.ProcessingContext

class TargetObjectPropertyReferenceProvider : BaseFieldReferenceProvider(){
    override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            val type = field.type
            if(type is PsiClassType && type.hasParameters()){
                val parameter = type.parameters.first()
                if(parameter is PsiClassType){
                    val paramaterClass = parameter.resolve()
                    if(paramaterClass != null){
                        return findConcrete(paramaterClass).map { References(it, element as PsiLiteralExpression) }.toTypedArray()
                    }
                }
            }
        return PsiReference.EMPTY_ARRAY
    }
}