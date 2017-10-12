package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.intellij.psi.PsiLiteralExpression
import com.intellij.util.containers.isNullOrEmpty
import com.pss.broadleaf.plugin.*
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection.CLASS_NAME_SET
import com.siyeh.ig.psiutils.TypeUtils

class AdminPresentationAdornedInspection : PresentationAnnotationInspection(presentationAnnotation = CLASS_NAME_SET){

    override fun inspect(psiClass: PsiClass, psiField: PsiField, annotation: PsiAnnotation, holder: ProblemsHolder) {

        val isCollection = psiField.isCollectionType()

        if(!isCollection){
            registerProblem(holder, psiField.typeElement?:psiField, "admin.adorned.collection")
            return
        }

        psiField.getCollectionComponent()?.let {
            if(!it.isEntity()){
                registerProblem(holder, psiField.typeElement?.innermostComponentReferenceElement?.parameterList?.typeParameterElements?.get(0)?:psiField, "admin.adorned.not-managed")
                return@inspect
            }
        }

        val mappedByField = psiField.getMappedBy()

        annotation.findDeclaredAttributeValue(AdminPresentationAdornedTargetCollection.TARGET_OBJECT_PROPERTY)?.let { memberValue ->
            if(memberValue is PsiLiteralExpression){
                val fields = psiField.getTargetEntity()?.getFields(memberValue.value as String)
                if(fields.isNullOrEmpty()){
                    registerProblem(holder, memberValue, "admin.adorned.target-object-property")
                } else {
                    if(!fields!!.any { !it.isSimpleType() && it.type.isEntity() }){
                        registerProblem(holder, memberValue, "admin.adorned.target-object-property.not-managed")
                    }
                }

            }
        }




    }
}