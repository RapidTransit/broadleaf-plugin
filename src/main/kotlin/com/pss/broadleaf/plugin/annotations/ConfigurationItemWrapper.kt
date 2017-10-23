package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class ConfigurationItemWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.ConfigurationItem"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.ConfigurationItem")
        val ITEM_NAME = "itemName" 
        val ITEM_VALUE = "itemValue" 

        val METHODS = mapOf<String, Class<out Any>>(Pair("itemName", String::class.java), Pair("itemValue", String::class.java))
        val ITEM_NAME_KEY = Key<Pair<PsiElement, String>?>("@itemName")
        val ITEM_VALUE_KEY = Key<Pair<PsiElement, String>?>("@itemValue")
    }


    override fun getMethods(): Map<String, Class<out Any>> {
        return METHODS
    }

    fun itemName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ITEM_NAME_KEY, { resolveDeclaredString(ITEM_NAME) })
    }
    
    fun _itemName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ITEM_NAME_KEY, { resolveString(ITEM_NAME) })
    }

    fun itemValue(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ITEM_VALUE_KEY, { resolveDeclaredString(ITEM_VALUE) })
    }
    
    fun _itemValue(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ITEM_VALUE_KEY, { resolveString(ITEM_VALUE) })
    }

}