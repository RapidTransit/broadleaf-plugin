package com.pss.broadleaf.plugin.inspections

import com.intellij.codeInspection.BaseJavaLocalInspectionTool
import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemsHolder

import com.intellij.psi.*
import com.pss.broadleaf.plugin.*
import com.pss.broadleaf.plugin.BroadleafConstants.AcceptableTypes
import com.pss.broadleaf.plugin.inspections.presentation.*

class EntityPresentationAnnotationInspection : BaseJavaLocalInspectionTool() {


    override fun getDisplayName(): String {
        return "Entity Presentation"
    }

    override fun getStaticDescription(): String? {
        return "Checks Entity's Have Correct Presentation Attributes"
    }

    override fun getGroupDisplayName(): String {
        return "BLC"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return EntityPresentationVisitor(holder)
    }


    class EntityPresentationVisitor(private val holder: ProblemsHolder) : JavaElementVisitor() {
        private val inspectors : List<PresentationAnnotationInspection>

        init {
            inspectors = listOf<PresentationAnnotationInspection>(
                    AdminPresentationInspection(),
                    AdminPresentationAdornedInspection(),
                    AdminPresentationToOneInspection(),
                    AdminPresentationCollectionInspection(),
                    AdminPresentationMapInspection())
        }

        override fun visitClass(psiClass: PsiClass?) {
            if (psiClass != null && psiClass.isAnnotated(AcceptableTypes.MANAGED_TYPES)) {
                psiClass.fields.forEach { psiField ->
                    if (!psiField.hasModifierProperty(PsiModifier.STATIC)) {
                        inspectors.forEach { it.inspect(psiClass, psiField, holder) }
                    }
                }
            }
        }

    }



}