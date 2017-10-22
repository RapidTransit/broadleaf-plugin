package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationMapKeyWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMapKey"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationMapKey")
        val FRIENDLY_KEY_NAME = "friendlyKeyName" 
        val KEY_NAME = "keyName" 

        val FRIENDLY_KEY_NAME_KEY = Key<Pair<PsiElement, String>?>("@friendlyKeyName")
        val KEY_NAME_KEY = Key<Pair<PsiElement, String>?>("@keyName")
    }


    fun friendlyKeyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_KEY_NAME_KEY, { resolveDeclaredString(FRIENDLY_KEY_NAME) })
    }
    
    fun _friendlyKeyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_KEY_NAME_KEY, { resolveString(FRIENDLY_KEY_NAME) })
    }

    fun keyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(KEY_NAME_KEY, { resolveDeclaredString(KEY_NAME) })
    }
    
    fun _keyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(KEY_NAME_KEY, { resolveString(KEY_NAME) })
    }

}