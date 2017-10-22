package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
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

        val ADD_TYPE_KEY = Key<Pair<PsiElement, String>?>("@addType")
        val FETCH_TYPE_KEY = Key<Pair<PsiElement, String>?>("@fetchType")
        val INSPECT_TYPE_KEY = Key<Pair<PsiElement, String>?>("@inspectType")
        val REMOVE_TYPE_KEY = Key<Pair<PsiElement, String>?>("@removeType")
        val UPDATE_TYPE_KEY = Key<Pair<PsiElement, String>?>("@updateType")
    }


    fun addType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ADD_TYPE_KEY, { resolveDeclaredEnum(ADD_TYPE) })
    }
    
    fun _addType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ADD_TYPE_KEY, { resolveEnum(ADD_TYPE) })
    }

    fun fetchType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FETCH_TYPE_KEY, { resolveDeclaredEnum(FETCH_TYPE) })
    }
    
    fun _fetchType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FETCH_TYPE_KEY, { resolveEnum(FETCH_TYPE) })
    }

    fun inspectType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(INSPECT_TYPE_KEY, { resolveDeclaredEnum(INSPECT_TYPE) })
    }
    
    fun _inspectType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(INSPECT_TYPE_KEY, { resolveEnum(INSPECT_TYPE) })
    }

    fun removeType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(REMOVE_TYPE_KEY, { resolveDeclaredEnum(REMOVE_TYPE) })
    }
    
    fun _removeType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(REMOVE_TYPE_KEY, { resolveEnum(REMOVE_TYPE) })
    }

    fun updateType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(UPDATE_TYPE_KEY, { resolveDeclaredEnum(UPDATE_TYPE) })
    }
    
    fun _updateType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(UPDATE_TYPE_KEY, { resolveEnum(UPDATE_TYPE) })
    }

}