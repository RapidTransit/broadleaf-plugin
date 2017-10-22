package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationCollectionOverrideWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationCollectionOverride"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.override.AdminPresentationCollectionOverride")
        val NAME = "name" 
        val VALUE = "value" 

        val NAME_KEY = Key<Pair<PsiElement, String>?>("@name")
        val VALUE_KEY = Key<PsiAnnotation?>("@value")
    }


    fun name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveDeclaredString(NAME) })
    }
    
    fun _name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveString(NAME) })
    }

    fun value(): AdminPresentationCollectionWrapper? {
        val anno = annotation.cacheGet(VALUE_KEY, { resolveDeclaredAnnotation(VALUE) })
        if(anno != null){
            return AdminPresentationCollectionWrapper(anno)
        }
        return null
    }
    
    fun _value(): AdminPresentationCollectionWrapper? {
        val anno =  annotation.cacheGet(VALUE_KEY, { resolveAnnotation(VALUE) })
        if(anno != null){
            return AdminPresentationCollectionWrapper(anno)
        }
        return null
    }

}