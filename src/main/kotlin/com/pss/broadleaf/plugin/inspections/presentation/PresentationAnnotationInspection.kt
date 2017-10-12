package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.*
import com.pss.broadleaf.plugin.*

abstract class PresentationAnnotationInspection(val presentationAnnotation: Set<String>) {
    
    fun inspect(clazz: PsiClass, field: PsiField, holder: ProblemsHolder){
        field.doWithAnnotation(presentationAnnotation, { psiField, psiAnnotation -> 
            inspect(clazz, field, psiAnnotation, holder)
        })
    }
    
    abstract fun inspect(psiClass: PsiClass, psiField: PsiField, annotation: PsiAnnotation, holder: ProblemsHolder)
    
    fun registerProblem(holder: ProblemsHolder, element: PsiElement, message: String){
        holder.registerProblem(element, message)
    }

}

