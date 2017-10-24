package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationToOneLookupWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup")
        val CUSTOM_CRITERIA = "customCriteria" 
        val ENABLE_TYPEAHEAD_LOOKUP = "enableTypeaheadLookup" 
        val FORCE_POPULATE_CHILD_PROPERTIES = "forcePopulateChildProperties" 
        val LOOKUP_DISPLAY_PROPERTY = "lookupDisplayProperty" 
        val LOOKUP_TYPE = "lookupType" 
        val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 

        val INVOKERS = mapOf<String, (AdminPresentationToOneLookupWrapper)->Any?>(Pair("customCriteria", {wrapper-> wrapper.customCriteria() }) , Pair("enableTypeaheadLookup", {wrapper-> wrapper.enableTypeaheadLookup() }) , Pair("forcePopulateChildProperties", {wrapper-> wrapper.forcePopulateChildProperties() }) , Pair("lookupDisplayProperty", {wrapper-> wrapper.lookupDisplayProperty() }) , Pair("lookupType", {wrapper-> wrapper.lookupType() }) , Pair("useServerSideInspectionCache", {wrapper-> wrapper.useServerSideInspectionCache() }) )
        val METHODS = mapOf<String, Class<out Any>>(Pair("customCriteria", Array<String>::class.java), Pair("enableTypeaheadLookup", Boolean::class.javaPrimitiveType!!), Pair("forcePopulateChildProperties", Boolean::class.javaPrimitiveType!!), Pair("lookupDisplayProperty", String::class.java), Pair("lookupType", Enum::class.java), Pair("useServerSideInspectionCache", Boolean::class.javaPrimitiveType!!))
        val CUSTOM_CRITERIA_KEY = Key<List<Pair<PsiElement, String>>>("@customCriteria")
        val ENABLE_TYPEAHEAD_LOOKUP_KEY = Key<Pair<PsiElement, Boolean>?>("@enableTypeaheadLookup")
        val FORCE_POPULATE_CHILD_PROPERTIES_KEY = Key<Pair<PsiElement, Boolean>?>("@forcePopulateChildProperties")
        val LOOKUP_DISPLAY_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@lookupDisplayProperty")
        val LOOKUP_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@lookupType")
        val USE_SERVER_SIDE_INSPECTION_CACHE_KEY = Key<Pair<PsiElement, Boolean>?>("@useServerSideInspectionCache")
    }


    override fun getMethods(): Map<String, Class<out Any>> {
        return METHODS
    }

    fun customCriteria(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(CUSTOM_CRITERIA_KEY, { resolveDeclaredStringArray(CUSTOM_CRITERIA) })
    }
    
    fun _customCriteria(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(CUSTOM_CRITERIA_KEY, { resolveStringArray(CUSTOM_CRITERIA) })
    }

    fun enableTypeaheadLookup(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(ENABLE_TYPEAHEAD_LOOKUP_KEY, { resolveDeclaredBoolean(ENABLE_TYPEAHEAD_LOOKUP) })
    }
    
    fun _enableTypeaheadLookup(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(ENABLE_TYPEAHEAD_LOOKUP_KEY, { resolveBoolean(ENABLE_TYPEAHEAD_LOOKUP) })
    }

    fun forcePopulateChildProperties(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(FORCE_POPULATE_CHILD_PROPERTIES_KEY, { resolveDeclaredBoolean(FORCE_POPULATE_CHILD_PROPERTIES) })
    }
    
    fun _forcePopulateChildProperties(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(FORCE_POPULATE_CHILD_PROPERTIES_KEY, { resolveBoolean(FORCE_POPULATE_CHILD_PROPERTIES) })
    }

    fun lookupDisplayProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(LOOKUP_DISPLAY_PROPERTY_KEY, { resolveDeclaredString(LOOKUP_DISPLAY_PROPERTY) })
    }
    
    fun _lookupDisplayProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(LOOKUP_DISPLAY_PROPERTY_KEY, { resolveString(LOOKUP_DISPLAY_PROPERTY) })
    }

    fun lookupType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(LOOKUP_TYPE_KEY, { resolveDeclaredEnum(LOOKUP_TYPE) })
    }
    
    fun _lookupType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(LOOKUP_TYPE_KEY, { resolveEnum(LOOKUP_TYPE) })
    }

    fun useServerSideInspectionCache(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(USE_SERVER_SIDE_INSPECTION_CACHE_KEY, { resolveDeclaredBoolean(USE_SERVER_SIDE_INSPECTION_CACHE) })
    }
    
    fun _useServerSideInspectionCache(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(USE_SERVER_SIDE_INSPECTION_CACHE_KEY, { resolveBoolean(USE_SERVER_SIDE_INSPECTION_CACHE) })
    }

}