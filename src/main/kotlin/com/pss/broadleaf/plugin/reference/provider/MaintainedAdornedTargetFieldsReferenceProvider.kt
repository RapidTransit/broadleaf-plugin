package com.pss.broadleaf.plugin.reference.provider

import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import com.pss.broadleaf.plugin.reference.References

class MaintainedAdornedTargetFieldsReferenceProvider : BaseFieldReferenceProvider(){
    override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {

           val type = field.type

            // Adorned fields can only be a collection type
           if(type is PsiClassType && type.hasParameters() && element is PsiLiteralExpression){
               val parameter = type.parameters.first()
               val value = element.value
               if(parameter is PsiClassType && value is String){

                   return parameter.resolve()?.let {

                        return findConcrete(it).map { References(it, element, value) }.toTypedArray()
                   }?: PsiReference.EMPTY_ARRAY
               }
           }

        return PsiReference.EMPTY_ARRAY
    }

}