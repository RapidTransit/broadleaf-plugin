package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationDataDrivenEnumerationWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration")
        val OPTION_CAN_EDIT_VALUES = "optionCanEditValues" 
        val OPTION_DISPLAY_FIELD_NAME = "optionDisplayFieldName" 
        val OPTION_FILTER_PARAMS = "optionFilterParams" 
        val OPTION_HIDE_IF_EMPTY = "optionHideIfEmpty" 
        val OPTION_LIST_ENTITY = "optionListEntity" 
        val OPTION_VALUE_FIELD_NAME = "optionValueFieldName" 

        val INVOKERS = mapOf<String, (AdminPresentationDataDrivenEnumerationWrapper)->Any?>(Pair("optionCanEditValues", {wrapper-> wrapper.optionCanEditValues() }) , Pair("optionDisplayFieldName", {wrapper-> wrapper.optionDisplayFieldName() }) , Pair("optionFilterParams", {wrapper-> wrapper.optionFilterParams() }) , Pair("optionHideIfEmpty", {wrapper-> wrapper.optionHideIfEmpty() }) , Pair("optionListEntity", {wrapper-> wrapper.optionListEntity() }) , Pair("optionValueFieldName", {wrapper-> wrapper.optionValueFieldName() }) )
        val METHODS = mapOf<String, Class<out Any>>(Pair("optionCanEditValues", Boolean::class.javaPrimitiveType!!), Pair("optionDisplayFieldName", String::class.java), Pair("optionFilterParams)", Array<Annotation>::class.java), Pair("optionHideIfEmpty", Boolean::class.javaPrimitiveType!!), Pair("optionListEntity", Class::class.java), Pair("optionValueFieldName", String::class.java))
        val OPTION_CAN_EDIT_VALUES_KEY = Key<Pair<PsiElement, Boolean>?>("@optionCanEditValues")
        val OPTION_DISPLAY_FIELD_NAME_KEY = Key<Pair<PsiElement, String>?>("@optionDisplayFieldName")
        val OPTION_FILTER_PARAMS_KEY = Key<List<PsiAnnotation>?>("@optionFilterParams")
        val OPTION_HIDE_IF_EMPTY_KEY = Key<Pair<PsiElement, Boolean>?>("@optionHideIfEmpty")
        val OPTION_LIST_ENTITY_KEY = Key<Pair<PsiElement, PsiClass>?>("@optionListEntity")
        val OPTION_VALUE_FIELD_NAME_KEY = Key<Pair<PsiElement, String>?>("@optionValueFieldName")
    }


    override fun getMethods(): Map<String, Class<out Any>> {
        return METHODS
    }

    fun optionCanEditValues(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(OPTION_CAN_EDIT_VALUES_KEY, { resolveDeclaredBoolean(OPTION_CAN_EDIT_VALUES) })
    }
    
    fun _optionCanEditValues(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(OPTION_CAN_EDIT_VALUES_KEY, { resolveBoolean(OPTION_CAN_EDIT_VALUES) })
    }

    fun optionDisplayFieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(OPTION_DISPLAY_FIELD_NAME_KEY, { resolveDeclaredString(OPTION_DISPLAY_FIELD_NAME) })
    }
    
    fun _optionDisplayFieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(OPTION_DISPLAY_FIELD_NAME_KEY, { resolveString(OPTION_DISPLAY_FIELD_NAME) })
    }

    fun optionFilterParams(): List<OptionFilterParamWrapper> {
        val anno = annotation.cacheGet(OPTION_FILTER_PARAMS_KEY, { resolveDeclaredAnnotationArray(OPTION_FILTER_PARAMS) })
        if(anno != null){
            return anno.map{ OptionFilterParamWrapper(it) }
        }
        return emptyList<OptionFilterParamWrapper>()
    }
    
    fun _optionFilterParams(): List<OptionFilterParamWrapper> {
        val anno =  annotation.cacheGet(OPTION_FILTER_PARAMS_KEY, { resolveAnnotationArray(OPTION_FILTER_PARAMS) })
        if(anno != null){
            return anno.map{ OptionFilterParamWrapper(it) }
        }
        return emptyList<OptionFilterParamWrapper>()
    }

    fun optionHideIfEmpty(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(OPTION_HIDE_IF_EMPTY_KEY, { resolveDeclaredBoolean(OPTION_HIDE_IF_EMPTY) })
    }
    
    fun _optionHideIfEmpty(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(OPTION_HIDE_IF_EMPTY_KEY, { resolveBoolean(OPTION_HIDE_IF_EMPTY) })
    }

    fun optionListEntity(): Pair<PsiElement, PsiClass>? {
        return annotation.cacheGet(OPTION_LIST_ENTITY_KEY, { resolveDeclaredClass(OPTION_LIST_ENTITY) })
    }
    
    fun _optionListEntity(): Pair<PsiElement, PsiClass>? {
        return annotation.cacheGet(OPTION_LIST_ENTITY_KEY, { resolveClass(OPTION_LIST_ENTITY) })
    }

    fun optionValueFieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(OPTION_VALUE_FIELD_NAME_KEY, { resolveDeclaredString(OPTION_VALUE_FIELD_NAME) })
    }
    
    fun _optionValueFieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(OPTION_VALUE_FIELD_NAME_KEY, { resolveString(OPTION_VALUE_FIELD_NAME) })
    }

}