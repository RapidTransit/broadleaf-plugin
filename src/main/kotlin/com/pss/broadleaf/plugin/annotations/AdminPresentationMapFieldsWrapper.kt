package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationMapFieldsWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMapFields"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationMapFields")
        val MAP_DISPLAY_FIELDS = "mapDisplayFields" 
        val TO_ONE_PARENT_PROPERTY = "toOneParentProperty" 
        val TO_ONE_TARGET_PROPERTY = "toOneTargetProperty" 

        val MAP_DISPLAY_FIELDS_KEY = Key<List<PsiAnnotation>?>("@mapDisplayFields")
        val TO_ONE_PARENT_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@toOneParentProperty")
        val TO_ONE_TARGET_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@toOneTargetProperty")
    }


    fun mapDisplayFields(): List<AdminPresentationMapFieldWrapper> {
        val anno = annotation.cacheGet(MAP_DISPLAY_FIELDS_KEY, { resolveDeclaredAnnotationArray(MAP_DISPLAY_FIELDS) })
        if(anno != null){
            return anno.map{ AdminPresentationMapFieldWrapper(it) }
        }
        return emptyList<AdminPresentationMapFieldWrapper>()
    }
    
    fun _mapDisplayFields(): List<AdminPresentationMapFieldWrapper> {
        val anno =  annotation.cacheGet(MAP_DISPLAY_FIELDS_KEY, { resolveAnnotationArray(MAP_DISPLAY_FIELDS) })
        if(anno != null){
            return anno.map{ AdminPresentationMapFieldWrapper(it) }
        }
        return emptyList<AdminPresentationMapFieldWrapper>()
    }

    fun toOneParentProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TO_ONE_PARENT_PROPERTY_KEY, { resolveDeclaredString(TO_ONE_PARENT_PROPERTY) })
    }
    
    fun _toOneParentProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TO_ONE_PARENT_PROPERTY_KEY, { resolveString(TO_ONE_PARENT_PROPERTY) })
    }

    fun toOneTargetProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TO_ONE_TARGET_PROPERTY_KEY, { resolveDeclaredString(TO_ONE_TARGET_PROPERTY) })
    }
    
    fun _toOneTargetProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TO_ONE_TARGET_PROPERTY_KEY, { resolveString(TO_ONE_TARGET_PROPERTY) })
    }

}