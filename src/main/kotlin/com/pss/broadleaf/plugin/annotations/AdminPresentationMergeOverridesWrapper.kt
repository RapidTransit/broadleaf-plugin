package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationMergeOverridesWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverrides"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverrides")
        val VALUE = "value" 

        val INVOKERS = mapOf<String, (AdminPresentationMergeOverridesWrapper)->Any?>(Pair("value", {wrapper-> wrapper.value() }) )
        val METHODS = mapOf<String, Class<out Any>>(Pair("value)", Array<Annotation>::class.java))
        val VALUE_KEY = Key<List<PsiAnnotation>?>("@value")
    }


    override fun getMethods(): Map<String, Class<out Any>> {
        return METHODS
    }

    fun value(): List<AdminPresentationMergeOverrideWrapper> {
        val anno = annotation.cacheGet(VALUE_KEY, { resolveDeclaredAnnotationArray(VALUE) })
        if(anno != null){
            return anno.map{ AdminPresentationMergeOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationMergeOverrideWrapper>()
    }
    
    fun _value(): List<AdminPresentationMergeOverrideWrapper> {
        val anno =  annotation.cacheGet(VALUE_KEY, { resolveAnnotationArray(VALUE) })
        if(anno != null){
            return anno.map{ AdminPresentationMergeOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationMergeOverrideWrapper>()
    }

}