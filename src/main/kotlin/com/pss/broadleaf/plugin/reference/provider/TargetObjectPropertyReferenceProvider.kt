package com.pss.broadleaf.plugin.reference.provider

import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import com.pss.broadleaf.plugin.findAllConcreteTypesWithThis
import com.pss.broadleaf.plugin.reference.References

class TargetObjectPropertyReferenceProvider : BaseFieldReferenceProvider(){
    override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            val type = field.type
            if(type is PsiClassType && type.hasParameters() && element is PsiLiteralExpression){
                val parameter = type.parameters.first()
                if(parameter is PsiClassType){
                    val parameterClass = parameter.resolve()
                    val value = element.value
                    if(parameterClass != null && value is String){
                        return parameterClass.findAllConcreteTypesWithThis().map { References(it, element, value) }.toTypedArray()
                    }
                }
            }
        return PsiReference.EMPTY_ARRAY
    }
}