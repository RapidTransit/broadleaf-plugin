package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminTabPresentationOverrideWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminTabPresentationOverride"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.override.AdminTabPresentationOverride")
        val PROPERTY = "property" 
        val TAB_NAME = "tabName" 
        val VALUE = "value" 

        val INVOKERS = mapOf<String, (AdminTabPresentationOverrideWrapper)->Any?>(Pair("property", {wrapper-> wrapper.property() }) , Pair("tabName", {wrapper-> wrapper.tabName() }) , Pair("value", {wrapper-> wrapper.value() }) )
        val METHODS = mapOf<String, OverrideType>(Pair("property", OverrideType.STRING), Pair("tabName", OverrideType.STRING), Pair("value", OverrideType.STRING))
        val PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@property")
        val TAB_NAME_KEY = Key<Pair<PsiElement, String>?>("@tabName")
        val VALUE_KEY = Key<Pair<PsiElement, String>?>("@value")
    }


    override fun getMethods(): Map<String, OverrideType> {
        return METHODS
    }

    fun property(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PROPERTY_KEY, { resolveDeclaredString(PROPERTY) })
    }
    
    fun _property(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PROPERTY_KEY, { resolveString(PROPERTY) })
    }

    fun tabName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TAB_NAME_KEY, { resolveDeclaredString(TAB_NAME) })
    }
    
    fun _tabName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TAB_NAME_KEY, { resolveString(TAB_NAME) })
    }

    fun value(): Pair<PsiElement, String>? {
        return annotation.cacheGet(VALUE_KEY, { resolveDeclaredString(VALUE) })
    }
    
    fun _value(): Pair<PsiElement, String>? {
        return annotation.cacheGet(VALUE_KEY, { resolveString(VALUE) })
    }

}