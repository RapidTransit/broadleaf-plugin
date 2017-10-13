package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.*
import com.pss.broadleaf.plugin.*

class AdminPresentationInspection : PresentationAnnotationInspection(BroadleafConstants.PresentationAnnotations.AdminPresentation.CLASS_NAME_SET){
    override fun inspect(psiClass: PsiClass, psiField: PsiField, annotation: PsiAnnotation, holder: ProblemsHolder) {

        val isCollection = psiField.isCollectionType()

        if(isCollection){
           registerProblem(holder, psiField, "admin.mismatch.presentation")
        }

        inspectSupportedFieldType(holder, annotation, psiClass, psiField, psiField)

        psiField.doWithAnnotation(BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection.CLASS_NAME_SET, { field, annotation ->
            registerProblem(holder, annotation, "admin.mismatch.adorned")
        })

        psiField.doWithAnnotation(BroadleafConstants.PresentationAnnotations.AdminPresentationMap.CLASS_NAME_SET, { field, annotation ->
            registerProblem(holder, annotation, "admin.mismatch.map")
        })

        psiField.doWithAnnotation(BroadleafConstants.PresentationAnnotations.AdminPresentationCollection.CLASS_NAME_SET, { field, annotation ->
            registerProblem(holder, annotation, "admin.mismatch.collection")
        })
    }

    private fun inspectSupportedFieldType(holder: ProblemsHolder, annotation: PsiAnnotation, psiClass: PsiClass, field: PsiField, psiField: PsiField) {
        annotation.findDeclaredAttributeValue(BroadleafConstants.PresentationAnnotations.AdminPresentation.FIELD_TYPE)?.let { annotationValue ->
            if (annotationValue is PsiReferenceExpression) {
                annotationValue.referenceName?.let {
                    when (it) {
                        BroadleafConstants.EnumTypes.SupportedFieldType.BOOLEAN -> {
                            if (!psiClass.isAssignable(BroadleafConstants.AcceptableTypes.BOOLEAN, field.type)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.BOOLEAN")
                            }
                        }
                        BroadleafConstants.EnumTypes.SupportedFieldType.DATE -> {
                            if (!psiClass.isAssignable(BroadleafConstants.AcceptableTypes.DATE, field.type)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.DATE")
                            }
                        }
                        BroadleafConstants.EnumTypes.SupportedFieldType.EMAIL,
                        BroadleafConstants.EnumTypes.SupportedFieldType.STRING,
                        BroadleafConstants.EnumTypes.SupportedFieldType.PASSWORD,
                        BroadleafConstants.EnumTypes.SupportedFieldType.PASSWORD_CONFIRM -> {
                            if (!psiClass.isAssignable(BroadleafConstants.AcceptableTypes.STRING, field.type)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.$it")
                            }
                        }
                        BroadleafConstants.EnumTypes.SupportedFieldType.HTML,
                        BroadleafConstants.EnumTypes.SupportedFieldType.HTML_BASIC,
                        BroadleafConstants.EnumTypes.SupportedFieldType.CODE,
                        BroadleafConstants.EnumTypes.SupportedFieldType.DESCRIPTION -> {

                            if (!psiClass.isAssignable(BroadleafConstants.AcceptableTypes.STRING, field.type)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.$it.type")
                            } else {
                                if (!field.isAnnotated(BroadleafConstants.JpaAnnotations.Type.CLASS_NAME)) {
                                    registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.$it.user-type")
                                }
                                if (!field.isAnnotated(BroadleafConstants.JpaAnnotations.Lob.CLASS_NAME)) {
                                    registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.$it.lob")
                                }
                            }
                        }
                        BroadleafConstants.EnumTypes.SupportedFieldType.INTEGER -> {
                            if (!psiClass.isAssignable(BroadleafConstants.AcceptableTypes.INTEGER, field.type)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.INTEGER")
                            }
                        }
                        BroadleafConstants.EnumTypes.SupportedFieldType.DECIMAL -> {
                            if (!psiClass.isAssignable(BroadleafConstants.AcceptableTypes.DECIMAL, field.type)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.DECIMAL")
                            }
                        }
                        BroadleafConstants.EnumTypes.SupportedFieldType.BROADLEAF_ENUMERATION -> {
                            if (!psiClass.isAssignable(BroadleafConstants.AcceptableTypes.STRING, field.type)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.BROADLEAF_ENUMERATION.string")
                            }
                            if (!isBroadleafEnumeration(annotation, psiClass, psiField)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.BROADLEAF_ENUMERATION.type")
                            }
                        }
                        BroadleafConstants.EnumTypes.SupportedFieldType.MONEY -> {
                            if (!psiClass.isAssignable(BroadleafConstants.AcceptableTypes.MONEY, field.type)) {
                                registerProblem(holder, psiField.typeElement?:field, "admin.presentation.supported-field-type.MONEY")
                            }
                        }
                    }
                }
            }

        }
    }

    private fun isBroadleafEnumeration(annotation: PsiAnnotation, psiClass: PsiClass, psiField: PsiField): Boolean {
        val annotationValue = annotation.findDeclaredAttributeValue(BroadleafConstants.PresentationAnnotations.AdminPresentation.BROADLEAF_ENUMERATION)
        if (annotationValue != null) {
            if (annotationValue is PsiLiteralExpression) {
                val type = psiClass.findPsiType(BroadleafConstants.FrameworkTypes.BROADLEAF_ENUMERATION_TYPE)
                if (type != null) {
                    if (psiClass.isAssignable(annotationValue.value as String, type)) {
                        return true
                    }
                }
            }
        }
        return false
    }
}