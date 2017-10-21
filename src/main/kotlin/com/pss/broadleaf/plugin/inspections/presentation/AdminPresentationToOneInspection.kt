package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.intellij.psi.PsiLiteralExpression
import com.pss.broadleaf.plugin.*
import com.siyeh.ig.psiutils.CollectionUtils

class AdminPresentationToOneInspection : PresentationAnnotationInspection(BroadleafConstants.PresentationAnnotations.AdminPresentationToOneLookup.CLASS_NAME_SET){

    override fun inspect(psiClass: PsiClass, psiField: PsiField, annotation: PsiAnnotation, holder: ProblemsHolder) {
        val isCollection = psiField.isCollectionType()
        // Can not be a Collection
        if(isCollection){
            holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.collection"))
        }

        // If the type is not an entity
        if(!psiField.type.isEntity() && !CollectionUtils.isCollectionClassOrInterface(psiField.type)) {
            holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.managed"))
        }

        val displayProperty = annotation.findDeclaredAttributeValue(BroadleafConstants.PresentationAnnotations.AdminPresentationToOneLookup.LOOKUP_DISPLAY_PROPERTY)

        if(displayProperty == null) {
            val nameType = psiField.type.getFields("name")

            // The referenced Entity doesn't have a name property
            if (nameType.isEmpty()) {
                holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.name-property.none"))
            }

            // If it is not a Collection Type (A collection type may have the 'name' property), has the
            // name property is not a simple type
            if (!isCollection && nameType.isNotEmpty() && !nameType.any { it.isSimpleType() }) {
                holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.name-property.simple"))
            }
        } else {
            if(displayProperty is PsiLiteralExpression){

                val nameType = displayProperty.valueIsString ({ psiField.type.getFields(it) }, emptyList())
                // If the Field is Not Found
                if (nameType.isEmpty()) {
                    holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.name-property.override.none"))
                }

                // If the Field is Found, Check the Referenced Property is a 'Simple' type
                if (nameType.isNotEmpty() && nameType.any { it.isSimpleType() }) {
                    holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.name-property.override.simple"))
                }
            }

        }
    }

}