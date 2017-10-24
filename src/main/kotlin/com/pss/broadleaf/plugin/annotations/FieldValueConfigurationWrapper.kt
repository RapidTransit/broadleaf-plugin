package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class FieldValueConfigurationWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.FieldValueConfiguration"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.FieldValueConfiguration")
        val FIELD_NAME = "fieldName" 
        val FIELD_VALUES = "fieldValues" 

        val INVOKERS = mapOf<String, (FieldValueConfigurationWrapper)->Any?>(Pair("fieldName", {wrapper-> wrapper.fieldName() }) , Pair("fieldValues", {wrapper-> wrapper.fieldValues() }) )
        val METHODS = mapOf<String, Class<out Any>>(Pair("fieldName", String::class.java), Pair("fieldValues", Array<String>::class.java))
        val FIELD_NAME_KEY = Key<Pair<PsiElement, String>?>("@fieldName")
        val FIELD_VALUES_KEY = Key<List<Pair<PsiElement, String>>>("@fieldValues")
    }


    override fun getMethods(): Map<String, Class<out Any>> {
        return METHODS
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