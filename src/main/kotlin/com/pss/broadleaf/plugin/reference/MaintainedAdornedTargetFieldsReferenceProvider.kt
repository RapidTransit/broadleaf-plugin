package com.pss.broadleaf.plugin.reference

import com.intellij.psi.*
import com.intellij.util.ProcessingContext

class MaintainedAdornedTargetFieldsReferenceProvider : BaseFieldReferenceProvider(){
    override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {

           val type = field.type

            // Adorned fields can only be a collection type
           if(type is PsiClassType && type.hasParameters()){
               val parameter = type.parameters.first()
               if(parameter is PsiClassType){
                   return parameter.resolve()?.let {
                        return findConcrete(it).map { References(it, element as PsiLiteralExpression, element.value as String) }.toTypedArray()
                   }?: PsiReference.EMPTY_ARRAY
               }
           }

        return PsiReference.EMPTY_ARRAY
    }

}