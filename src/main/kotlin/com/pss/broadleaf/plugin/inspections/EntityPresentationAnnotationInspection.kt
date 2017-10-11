package com.pss.broadleaf.plugin.inspections

import com.intellij.codeInspection.BaseJavaLocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.lang.jvm.JvmModifier
import com.intellij.psi.*
import com.pss.broadleaf.plugin.*
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationCollection
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationMap
import com.pss.broadleaf.plugin.BroadleafConstants.AcceptableTypes
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentation
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationToOneLookup
import com.pss.broadleaf.plugin.BroadleafConstants.EnumTypes.SupportedFieldType
import com.siyeh.ig.psiutils.CollectionUtils

class EntityPresentationAnnotationInspection : BaseJavaLocalInspectionTool() {



    override fun getDisplayName(): String {
        return "Entity Presentation"
    }

    override fun getStaticDescription(): String? {
        return "Checks Entity's Have Correct PresentationAttributes"
    }

    override fun getGroupDisplayName(): String {
        return "BLC"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return EntityPresentationVisitor(holder)
    }

    class EntityPresentationVisitor(private val holder: ProblemsHolder) : JavaElementVisitor() {

        override fun visitClass(psiClass: PsiClass?) {

            if (psiClass != null && psiClass.isAnnotated(AcceptableTypes.MANAGED_TYPES)) {
                psiClass.fields.forEach { psiField ->
                    if(!psiField.hasModifier(JvmModifier.STATIC)){
                        psiField.doWithAnnotation(AdminPresentation.CLASS_NAME_SET, { field, annotation ->

                            // Make Sure it is not a Collection Type
                            if(CollectionUtils.isCollectionClassOrInterface(field.type)){
                                holder.registerProblem(psiField, InspectionBundle.message("admin.mismatch.presentation"))
                            }

                            inspectSupportedFieldType(annotation, psiClass, field, psiField)

                            psiField.doWithAnnotation(AdminPresentationAdornedTargetCollection.CLASS_NAME_SET, {field, annotation ->
                                holder.registerProblem(psiField, InspectionBundle.message("admin.mismatch.adorned"))
                            })

                            psiField.doWithAnnotation(AdminPresentationMap.CLASS_NAME_SET, {field, annotation ->
                                holder.registerProblem(psiField, InspectionBundle.message("admin.mismatch.map"))
                            })

                            psiField.doWithAnnotation(AdminPresentationCollection.CLASS_NAME_SET, {field, annotation ->
                                holder.registerProblem(psiField, InspectionBundle.message("admin.mismatch.collection"))
                            })


                        })

                        // @AdminPresentationToOneLookup
                        psiField.doWithAnnotation(AdminPresentationToOneLookup.CLASS_NAME_SET, { field, annotation ->

                            if(CollectionUtils.isCollectionClassOrInterface(field.type)){
                                holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.collection"))
                            }

                            if(!field.type.isEntity() && !CollectionUtils.isCollectionClassOrInterface(field.type)) {
                                holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.managed"))
                            }

                            val displayProperty = annotation.findDeclaredAttributeValue(AdminPresentationToOneLookup.LOOKUP_DISPLAY_PROPERTY)

                            if(displayProperty == null) {
                                val nameType = field.type.getFields("name")
                                if (nameType.isEmpty()) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.name-property.none"))
                                }

                                if (nameType.isNotEmpty() && nameType.any { it.isSimpleType() }) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.name-property.simple"))
                                }
                            } else {
                                if(displayProperty is PsiLiteralExpression){
                                    val nameType = field.type.getFields(displayProperty.value as String)
                                    if (nameType.isEmpty()) {
                                        holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.name-property.override.none"))
                                    }

                                    if (nameType.isNotEmpty() && nameType.any { it.isSimpleType() }) {
                                        holder.registerProblem(psiField, InspectionBundle.message("admin.to-one.name-property.override.simple"))
                                    }
                                }

                            }


                        })
                }

            }

        }
    }

        private fun inspectSupportedFieldType(annotation: PsiAnnotation, psiClass: PsiClass, field: PsiField, psiField: PsiField) {
            annotation.findDeclaredAttributeValue(AdminPresentation.FIELD_TYPE)?.let { annotationValue ->
                if (annotationValue is PsiReferenceExpression) {
                    annotationValue.referenceName?.let {
                        when (it) {
                            SupportedFieldType.BOOLEAN -> {
                                if (!psiClass.isAssignable(AcceptableTypes.BOOLEAN, field.type)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.boolean"))
                                }
                            }
                            SupportedFieldType.DATE -> {
                                if (!psiClass.isAssignable(AcceptableTypes.DATE, field.type)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.date"))
                                }
                            }
                            SupportedFieldType.EMAIL,
                            SupportedFieldType.STRING,
                            SupportedFieldType.PASSWORD,
                            SupportedFieldType.PASSWORD_CONFIRM -> {
                                if (!psiClass.isAssignable(AcceptableTypes.STRING, field.type)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.string"))
                                }
                            }
                            SupportedFieldType.HTML,
                            SupportedFieldType.HTML_BASIC,
                            SupportedFieldType.CODE,
                            SupportedFieldType.DESCRIPTION -> {
                                if (!field.isAnnotated(BroadleafConstants.JpaAnnotations.Type.CLASS_NAME)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.html.user-type"))
                                }
                                if (!field.isAnnotated(BroadleafConstants.JpaAnnotations.Lob.CLASS_NAME)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.html.lob"))
                                }
                                if (!psiClass.isAssignable(AcceptableTypes.STRING, field.type)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.string"))
                                }
                            }
                            SupportedFieldType.INTEGER -> {
                                if (!psiClass.isAssignable(AcceptableTypes.INTEGER, field.type)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.integer"))
                                }
                            }
                            SupportedFieldType.DECIMAL -> {
                                if (!psiClass.isAssignable(AcceptableTypes.DECIMAL, field.type)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.decimal"))
                                }
                            }
                            SupportedFieldType.BROADLEAF_ENUMERATION -> {
                                if (!psiClass.isAssignable(AcceptableTypes.STRING, field.type)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.broadleaf-enumeration.string"))
                                }
                                if (!isBroadleafEnumeration(annotation, psiClass, psiField)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.broadleaf-enumeration.type"))
                                }
                            }
                            SupportedFieldType.MONEY -> {
                                if (!psiClass.isAssignable(AcceptableTypes.MONEY, field.type)) {
                                    holder.registerProblem(psiField, InspectionBundle.message("admin.presentation.supported-field-type.money"))
                                }
                            }
                        }
                    }
                }

            }
        }

        private fun isBroadleafEnumeration(annotation: PsiAnnotation, psiClass: PsiClass, psiField: PsiField): Boolean {
            val annotationValue = annotation.findDeclaredAttributeValue(AdminPresentation.BROADLEAF_ENUMERATION)
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

        inline fun <T>notNull(t: T, function: (T) -> Unit): Unit {
            if(t != null){
                function(t)
            }
        }
    }
}