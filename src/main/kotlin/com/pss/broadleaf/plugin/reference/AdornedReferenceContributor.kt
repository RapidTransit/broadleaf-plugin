package com.pss.broadleaf.plugin.reference

import com.intellij.openapi.diagnostic.Logger
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PsiJavaPatterns
import com.intellij.psi.*

import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection as Adorned

class AdornedReferenceContributor : PsiReferenceContributor() {

    companion object {
        val LOG : Logger  = Logger.getInstance(AdornedReferenceContributor::class.java);
        val TARGET_OBJECT_PROPERTY: ElementPattern<out PsiElement> = PsiJavaPatterns.psiLiteral()
                .annotationParam(Adorned.CLASS_NAME, Adorned.TARGET_OBJECT_PROPERTY)
        val GRID_VISIBLE_FIELDS: ElementPattern<out PsiElement> = PsiJavaPatterns.or(PsiJavaPatterns.psiLiteral()
                .annotationParam(Adorned.CLASS_NAME, Adorned.GRID_VISIBLE_FIELDS),
                PsiJavaPatterns.psiLiteral().inside(PsiJavaPatterns.psiElement(PsiArrayInitializerMemberValue::class.java).annotationParam(Adorned.CLASS_NAME, Adorned.GRID_VISIBLE_FIELDS)))
        val MAINTAINED_ADORNED_TARGET_FIELDS: ElementPattern<out PsiElement> = PsiJavaPatterns.psiLiteral()
                .annotationParam(Adorned.CLASS_NAME, Adorned.MAINTAINED_ADORNED_TARGET_FIELDS)
    }


    enum class FieldRestriction {
        NONE, SIMPLE_TYPES_ONLY, ENTITY_TYPES_ONLY
    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(TARGET_OBJECT_PROPERTY, TargetObjectPropertyReferenceProvider())
        registrar.registerReferenceProvider(MAINTAINED_ADORNED_TARGET_FIELDS, MaintainedAdornedTargetFieldsReferenceProvider())
        registrar.registerReferenceProvider(GRID_VISIBLE_FIELDS, GridVisibleFieldsReferenceProvider())
    }


}