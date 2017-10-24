package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationToOneLookupOverrideWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationToOneLookupOverride"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.override.AdminPresentationToOneLookupOverride")
        val NAME = "name" 
        val VALUE = "value" 

        val INVOKERS = mapOf<String, (AdminPresentationToOneLookupOverrideWrapper)->Any?>(Pair("name", {wrapper-> wrapper.name() }) , Pair("value", {wrapper-> wrapper.value() }) )
        val METHODS = mapOf<String, Class<out Any>>(Pair("name", String::class.java), Pair("value)", Annotation::class.java))
        val NAME_KEY = Key<Pair<PsiElement, String>?>("@name")
        val VALUE_KEY = Key<PsiAnnotation?>("@value")
    }


    override fun getMethods(): Map<String, Class<out Any>> {
        return METHODS
    }

    fun name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveDeclaredString(NAME) })
    }
    
    fun _name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveString(NAME) })
    }

    fun value(): AdminPresentationToOneLookupWrapper? {
        val anno = annotation.cacheGet(VALUE_KEY, { resolveDeclaredAnnotation(VALUE) })
        if(anno != null){
            return AdminPresentationToOneLookupWrapper(anno)
        }
        return null
    }
    
    fun _value(): AdminPresentationToOneLookupWrapper? {
        val anno =  annotation.cacheGet(VALUE_KEY, { resolveAnnotation(VALUE) })
        if(anno != null){
            return AdminPresentationToOneLookupWrapper(anno)
        }
        return null
    }

}