package com.pss.broadleaf.plugin.reference

import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import com.pss.broadleaf.plugin.findAllConcreteTypes
import com.pss.broadleaf.plugin.findAllConcreteTypesWithThis

class TargetObjectPropertyReferenceProvider : BaseFieldReferenceProvider(){
    override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            val type = field.type
            if(type is PsiClassType && type.hasParameters() && element is PsiLiteralExpression){
                val parameter = type.parameters.first()
                if(parameter is PsiClassType){
                    val parameterClass = parameter.resolve()
                    if(parameterClass != null){

                        return parameterClass.findAllConcreteTypesWithThis().map { References(it, element, element.value as String) }.toTypedArray()
                    }
                }
            }
        return PsiReference.EMPTY_ARRAY
    }
}