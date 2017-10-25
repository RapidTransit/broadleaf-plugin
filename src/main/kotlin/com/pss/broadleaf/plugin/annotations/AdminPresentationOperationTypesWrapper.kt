package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationOperationTypesWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes")
        val ADD_TYPE = "addType" 
        val FETCH_TYPE = "fetchType" 
        val INSPECT_TYPE = "inspectType" 
        val REMOVE_TYPE = "removeType" 
        val UPDATE_TYPE = "updateType" 

        val INVOKERS = mapOf<String, (AdminPresentationOperationTypesWrapper)->Any?>(Pair("addType", {wrapper-> wrapper.addType() }) , Pair("fetchType", {wrapper-> wrapper.fetchType() }) , Pair("inspectType", {wrapper-> wrapper.inspectType() }) , Pair("removeType", {wrapper-> wrapper.removeType() }) , Pair("updateType", {wrapper-> wrapper.updateType() }) )
        val METHODS = mapOf<String, OverrideType>(Pair("addType", OverrideType.ENUM), Pair("fetchType", OverrideType.ENUM), Pair("inspectType", OverrideType.ENUM), Pair("removeType", OverrideType.ENUM), Pair("updateType", OverrideType.ENUM))
        val ADD_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@addType")
        val FETCH_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@fetchType")
        val INSPECT_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@inspectType")
        val REMOVE_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@removeType")
        val UPDATE_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@updateType")
    }


    override fun getMethods(): Map<String, OverrideType> {
        return METHODS
    }

    fun addType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(ADD_TYPE_KEY, { resolveDeclaredEnum(ADD_TYPE) })
    }
    
    fun _addType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(ADD_TYPE_KEY, { resolveEnum(ADD_TYPE) })
    }

    fun fetchType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(FETCH_TYPE_KEY, { resolveDeclaredEnum(FETCH_TYPE) })
    }
    
    fun _fetchType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(FETCH_TYPE_KEY, { resolveEnum(FETCH_TYPE) })
    }

    fun inspectType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(INSPECT_TYPE_KEY, { resolveDeclaredEnum(INSPECT_TYPE) })
    }
    
    fun _inspectType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(INSPECT_TYPE_KEY, { resolveEnum(INSPECT_TYPE) })
    }

    fun removeType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(REMOVE_TYPE_KEY, { resolveDeclaredEnum(REMOVE_TYPE) })
    }
    
    fun _removeType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(REMOVE_TYPE_KEY, { resolveEnum(REMOVE_TYPE) })
    }

    fun updateType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(UPDATE_TYPE_KEY, { resolveDeclaredEnum(UPDATE_TYPE) })
    }
    
    fun _updateType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(UPDATE_TYPE_KEY, { resolveEnum(UPDATE_TYPE) })
    }

}