package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationMapFieldWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMapField"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationMapField")
        val FIELD_NAME = "fieldName" 
        val FIELD_PRESENTATION = "fieldPresentation" 
        val MANY_TO_FIELD = "manyToField" 
        val TARGET_CLASS = "targetClass" 

        val INVOKERS = mapOf<String, (AdminPresentationMapFieldWrapper)->Any?>(Pair("fieldName", {wrapper-> wrapper.fieldName() }) , Pair("fieldPresentation", {wrapper-> wrapper.fieldPresentation() }) , Pair("manyToField", {wrapper-> wrapper.manyToField() }) , Pair("targetClass", {wrapper-> wrapper.targetClass() }) )
        val METHODS = mapOf<String, OverrideType>(Pair("fieldName", OverrideType.STRING), Pair("fieldPresentation)", OverrideType.ANNOTATION), Pair("manyToField", OverrideType.STRING), Pair("targetClass", OverrideType.CLASS))
        val FIELD_NAME_KEY = Key<Pair<PsiElement, String>?>("@fieldName")
        val FIELD_PRESENTATION_KEY = Key<PsiAnnotation?>("@fieldPresentation")
        val MANY_TO_FIELD_KEY = Key<Pair<PsiElement, String>?>("@manyToField")
        val TARGET_CLASS_KEY = Key<Pair<PsiElement, PsiClass>?>("@targetClass")
    }


    override fun getMethods(): Map<String, OverrideType> {
        return METHODS
    }

    fun fieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FIELD_NAME_KEY, { resolveDeclaredString(FIELD_NAME) })
    }
    
    fun _fieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FIELD_NAME_KEY, { resolveString(FIELD_NAME) })
    }

    fun fieldPresentation(): AdminPresentationWrapper? {
        val anno = annotation.cacheGet(FIELD_PRESENTATION_KEY, { resolveDeclaredAnnotation(FIELD_PRESENTATION) })
        if(anno != null){
            return AdminPresentationWrapper(anno)
        }
        return null
    }
    
    fun _fieldPresentation(): AdminPresentationWrapper? {
        val anno =  annotation.cacheGet(FIELD_PRESENTATION_KEY, { resolveAnnotation(FIELD_PRESENTATION) })
        if(anno != null){
            return AdminPresentationWrapper(anno)
        }
        return null
    }

    fun manyToField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MANY_TO_FIELD_KEY, { resolveDeclaredString(MANY_TO_FIELD) })
    }
    
    fun _manyToField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MANY_TO_FIELD_KEY, { resolveString(MANY_TO_FIELD) })
    }

    fun targetClass(): Pair<PsiElement, PsiClass>? {
        return annotation.cacheGet(TARGET_CLASS_KEY, { resolveDeclaredClass(TARGET_CLASS) })
    }
    
    fun _targetClass(): Pair<PsiElement, PsiClass>? {
        return annotation.cacheGet(TARGET_CLASS_KEY, { resolveClass(TARGET_CLASS) })
    }

}