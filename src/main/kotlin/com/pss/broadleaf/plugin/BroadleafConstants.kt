package com.pss.broadleaf.plugin

object BroadleafConstants {
    val ENTITY = "javax.persistence.Entity"
    val MAPPED_SUPER_CLASS = "javax.persistence.MappedSuperclass"
    val EMBEDDABLE = "javax.persistence.Embeddable"
    val MANAGED_TYPES = setOf<String>(ENTITY, MAPPED_SUPER_CLASS, EMBEDDABLE)
    val PRESENTATION_COLLECTION = "org.broadleafcommerce.common.presentation.AdminPresentationCollection"
    val PRESENTATION = "org.broadleafcommerce.common.presentation.AdminPresentation"
    val PRESENTATION_TO_ONE = "org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup"
    val ADORNED_TARGET = "org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection"
}