package com.pss.broadleaf.plugin.reference

import com.intellij.psi.*
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.util.ProcessingContext
import com.pss.broadleaf.plugin.getField

abstract class BaseFieldReferenceProvider : PsiReferenceProvider() {

    override final fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        val field = element.getField()
        if(field == null){
            return PsiReference.EMPTY_ARRAY
        } else {
            return getReferencesByElement(field, element, context)
        }
    }

    protected fun findConcrete(clazz: PsiClass): List<PsiClass> {
         ClassInheritorsSearch.search(clazz).findAll().filter { !it.isInterface }.let{
            if(!clazz.isInterface){
                return it.plus(clazz)
            }
            return it
        }
    }

    abstract protected fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference>

}