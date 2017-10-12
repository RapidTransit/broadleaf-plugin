package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.*
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationCollection.CLASS_NAME_SET

class AdminPresentationCollectionInspection : PresentationAnnotationInspection(presentationAnnotation = CLASS_NAME_SET) {

    override fun inspect(psiClass: PsiClass, psiField: PsiField, annotation: PsiAnnotation, holder: ProblemsHolder) {
        if(!psiField.isCollectionType()){
            registerProblem(holder, psiField.typeElement?:psiField, "admin.collection.type")
            return
        }
        val collectionComponent = psiField.getCollectionComponent()
        if(collectionComponent != null && !collectionComponent.isEntity()){
            registerProblem(holder, psiField.getTypeElementOrField(0), "admin.collection.not-managed")
        }

    }
}