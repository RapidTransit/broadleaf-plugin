package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class FieldValueConfigurationWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.FieldValueConfiguration"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.FieldValueConfiguration")
        val FIELD_NAME = "fieldName" 
        val FIELD_VALUES = "fieldValues" 

        val FIELD_NAME_KEY = Key<Pair<PsiElement, String>?>("@fieldName")
        val FIELD_VALUES_KEY = Key<List<Pair<PsiElement, String>>>("@fieldValues")
    }


    fun fieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FIELD_NAME_KEY, { resolveDeclaredString(FIELD_NAME) })
    }
    
    fun _fieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FIELD_NAME_KEY, { resolveString(FIELD_NAME) })
    }

    fun fieldValues(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(FIELD_VALUES_KEY, { resolveDeclaredStringArray(FIELD_VALUES) })
    }
    
    fun _fieldValues(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(FIELD_VALUES_KEY, { resolveStringArray(FIELD_VALUES) })
    }

}