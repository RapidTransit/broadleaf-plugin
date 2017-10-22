package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationClassWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationClass"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationClass")
        val CEILING_DISPLAY_ENTITY = "ceilingDisplayEntity" 
        val EXCLUDE_FROM_POLYMORPHISM = "excludeFromPolymorphism" 
        val FRIENDLY_NAME = "friendlyName" 
        val GROUP_OVERRIDES = "groupOverrides" 
        val POPULATE_TO_ONE_FIELDS = "populateToOneFields" 
        val TAB_OVERRIDES = "tabOverrides" 
        val TABS = "tabs" 

        val CEILING_DISPLAY_ENTITY_KEY = Key<Pair<PsiElement, String>?>("@ceilingDisplayEntity")
        val EXCLUDE_FROM_POLYMORPHISM_KEY = Key<Pair<PsiElement, Boolean>?>("@excludeFromPolymorphism")
        val FRIENDLY_NAME_KEY = Key<Pair<PsiElement, String>?>("@friendlyName")
        val GROUP_OVERRIDES_KEY = Key<List<PsiAnnotation>?>("@groupOverrides")
        val POPULATE_TO_ONE_FIELDS_KEY = Key<Pair<PsiElement, String>?>("@populateToOneFields")
        val TAB_OVERRIDES_KEY = Key<List<PsiAnnotation>?>("@tabOverrides")
        val TABS_KEY = Key<List<PsiAnnotation>?>("@tabs")
    }


    fun ceilingDisplayEntity(): Pair<PsiElement, String>? {
        return annotation.cacheGet(CEILING_DISPLAY_ENTITY_KEY, { resolveDeclaredString(CEILING_DISPLAY_ENTITY) })
    }
    
    fun _ceilingDisplayEntity(): Pair<PsiElement, String>? {
        return annotation.cacheGet(CEILING_DISPLAY_ENTITY_KEY, { resolveString(CEILING_DISPLAY_ENTITY) })
    }

    fun excludeFromPolymorphism(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(EXCLUDE_FROM_POLYMORPHISM_KEY, { resolveDeclaredBoolean(EXCLUDE_FROM_POLYMORPHISM) })
    }
    
    fun _excludeFromPolymorphism(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(EXCLUDE_FROM_POLYMORPHISM_KEY, { resolveBoolean(EXCLUDE_FROM_POLYMORPHISM) })
    }

    fun friendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_NAME_KEY, { resolveDeclaredString(FRIENDLY_NAME) })
    }
    
    fun _friendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_NAME_KEY, { resolveString(FRIENDLY_NAME) })
    }

    fun groupOverrides(): List<AdminGroupPresentationOverrideWrapper> {
        val anno = annotation.cacheGet(GROUP_OVERRIDES_KEY, { resolveDeclaredAnnotationArray(GROUP_OVERRIDES) })
        if(anno != null){
            return anno.map{ AdminGroupPresentationOverrideWrapper(it) }
        }
        return emptyList<AdminGroupPresentationOverrideWrapper>()
    }
    
    fun _groupOverrides(): List<AdminGroupPresentationOverrideWrapper> {
        val anno =  annotation.cacheGet(GROUP_OVERRIDES_KEY, { resolveAnnotationArray(GROUP_OVERRIDES) })
        if(anno != null){
            return anno.map{ AdminGroupPresentationOverrideWrapper(it) }
        }
        return emptyList<AdminGroupPresentationOverrideWrapper>()
    }

    fun populateToOneFields(): Pair<PsiElement, String>? {
        return annotation.cacheGet(POPULATE_TO_ONE_FIELDS_KEY, { resolveDeclaredEnum(POPULATE_TO_ONE_FIELDS) })
    }
    
    fun _populateToOneFields(): Pair<PsiElement, String>? {
        return annotation.cacheGet(POPULATE_TO_ONE_FIELDS_KEY, { resolveEnum(POPULATE_TO_ONE_FIELDS) })
    }

    fun tabOverrides(): List<AdminTabPresentationOverrideWrapper> {
        val anno = annotation.cacheGet(TAB_OVERRIDES_KEY, { resolveDeclaredAnnotationArray(TAB_OVERRIDES) })
        if(anno != null){
            return anno.map{ AdminTabPresentationOverrideWrapper(it) }
        }
        return emptyList<AdminTabPresentationOverrideWrapper>()
    }
    
    fun _tabOverrides(): List<AdminTabPresentationOverrideWrapper> {
        val anno =  annotation.cacheGet(TAB_OVERRIDES_KEY, { resolveAnnotationArray(TAB_OVERRIDES) })
        if(anno != null){
            return anno.map{ AdminTabPresentationOverrideWrapper(it) }
        }
        return emptyList<AdminTabPresentationOverrideWrapper>()
    }

    fun tabs(): List<AdminTabPresentationWrapper> {
        val anno = annotation.cacheGet(TABS_KEY, { resolveDeclaredAnnotationArray(TABS) })
        if(anno != null){
            return anno.map{ AdminTabPresentationWrapper(it) }
        }
        return emptyList<AdminTabPresentationWrapper>()
    }
    
    fun _tabs(): List<AdminTabPresentationWrapper> {
        val anno =  annotation.cacheGet(TABS_KEY, { resolveAnnotationArray(TABS) })
        if(anno != null){
            return anno.map{ AdminTabPresentationWrapper(it) }
        }
        return emptyList<AdminTabPresentationWrapper>()
    }

}