package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationMergeEntryWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry")
        val BOOLEAN_ARRAY_OVERRIDE_VALUE = "booleanArrayOverrideValue" 
        val BOOLEAN_OVERRIDE_VALUE = "booleanOverrideValue" 
        val DOUBLE_ARRAY_OVERRIDE_VALUE = "doubleArrayOverrideValue" 
        val DOUBLE_OVERRIDE_VALUE = "doubleOverrideValue" 
        val FLOAT_ARRAY_OVERRIDE_VALUE = "floatArrayOverrideValue" 
        val FLOAT_OVERRIDE_VALUE = "floatOverrideValue" 
        val INT_ARRAY_OVERRIDE_VALUE = "intArrayOverrideValue" 
        val INT_OVERRIDE_VALUE = "intOverrideValue" 
        val KEYS = "keys" 
        val LONG_ARRAY_OVERRIDE_VALUE = "longArrayOverrideValue" 
        val LONG_OVERRIDE_VALUE = "longOverrideValue" 
        val OPERATION_TYPES = "operationTypes" 
        val OPTION_FILTER_PARAMS = "optionFilterParams" 
        val OVERRIDE_VALUE = "overrideValue" 
        val PROPERTY_TYPE = "propertyType" 
        val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
        val STRING_ARRAY_OVERRIDE_VALUE = "stringArrayOverrideValue" 
        val VALIDATION_CONFIGURATIONS = "validationConfigurations" 

        val BOOLEAN_ARRAY_OVERRIDE_VALUE_KEY = Key<Pair<PsiElement, Boolean>?>("@booleanArrayOverrideValue")
        val BOOLEAN_OVERRIDE_VALUE_KEY = Key<Pair<PsiElement, Boolean>?>("@booleanOverrideValue")
        val INT_ARRAY_OVERRIDE_VALUE_KEY = Key<List<Pair<PsiElement, Int>>>("@intArrayOverrideValue")
        val INT_OVERRIDE_VALUE_KEY = Key<Pair<PsiElement, Int>?>("@intOverrideValue")
        val KEYS_KEY = Key<List<PsiAnnotation>?>("@keys")
        val OPERATION_TYPES_KEY = Key<PsiAnnotation?>("@operationTypes")
        val OPTION_FILTER_PARAMS_KEY = Key<List<PsiAnnotation>?>("@optionFilterParams")
        val OVERRIDE_VALUE_KEY = Key<Pair<PsiElement, String>?>("@overrideValue")
        val PROPERTY_TYPE_KEY = Key<Pair<PsiElement, String>?>("@propertyType")
        val SHOW_IF_FIELD_EQUALS_KEY = Key<List<PsiAnnotation>?>("@showIfFieldEquals")
        val STRING_ARRAY_OVERRIDE_VALUE_KEY = Key<List<Pair<PsiElement, String>>>("@stringArrayOverrideValue")
        val VALIDATION_CONFIGURATIONS_KEY = Key<List<PsiAnnotation>?>("@validationConfigurations")
    }


    fun booleanArrayOverrideValue(): List<Pair<PsiElement, Boolean>> {
        return annotation.cacheGet(BOOLEAN_ARRAY_OVERRIDE_VALUE_KEY, { resolveDeclaredBooleanArray(BOOLEAN_ARRAY_OVERRIDE_VALUE) })
    }
    
    fun _booleanArrayOverrideValue(): List<Pair<PsiElement, Boolean>> {
        return annotation.cacheGet(BOOLEAN_ARRAY_OVERRIDE_VALUE_KEY, { resolveBooleanArray(BOOLEAN_ARRAY_OVERRIDE_VALUE) })
    }

    fun booleanOverrideValue(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(BOOLEAN_OVERRIDE_VALUE_KEY, { resolveDeclaredBoolean(BOOLEAN_OVERRIDE_VALUE) })
    }
    
    fun _booleanOverrideValue(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(BOOLEAN_OVERRIDE_VALUE_KEY, { resolveBoolean(BOOLEAN_OVERRIDE_VALUE) })
    }

    fun intArrayOverrideValue(): List<Pair<PsiElement, Int>> {
        return annotation.cacheGet(INT_ARRAY_OVERRIDE_VALUE_KEY, { resolveDeclaredIntegerArray(INT_ARRAY_OVERRIDE_VALUE) })
    }
    
    fun _intArrayOverrideValue(): List<Pair<PsiElement, Int>> {
        return annotation.cacheGet(INT_ARRAY_OVERRIDE_VALUE_KEY, { resolveIntegerArray(INT_ARRAY_OVERRIDE_VALUE) })
    }

    fun intOverrideValue(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(INT_OVERRIDE_VALUE_KEY, { resolveDeclaredInteger(INT_OVERRIDE_VALUE) })
    }
    
    fun _intOverrideValue(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(INT_OVERRIDE_VALUE_KEY, { resolveInteger(INT_OVERRIDE_VALUE) })
    }

    fun keys(): List<AdminPresentationMapKeyWrapper> {
        val anno = annotation.cacheGet(KEYS_KEY, { resolveDeclaredAnnotationArray(KEYS) })
        if(anno != null){
            return anno.map{ AdminPresentationMapKeyWrapper(it) }
        }
        return emptyList<AdminPresentationMapKeyWrapper>()
    }
    
    fun _keys(): List<AdminPresentationMapKeyWrapper> {
        val anno =  annotation.cacheGet(KEYS_KEY, { resolveAnnotationArray(KEYS) })
        if(anno != null){
            return anno.map{ AdminPresentationMapKeyWrapper(it) }
        }
        return emptyList<AdminPresentationMapKeyWrapper>()
    }

    fun operationTypes(): AdminPresentationOperationTypesWrapper? {
        val anno = annotation.cacheGet(OPERATION_TYPES_KEY, { resolveDeclaredAnnotation(OPERATION_TYPES) })
        if(anno != null){
            return AdminPresentationOperationTypesWrapper(anno)
        }
        return null
    }
    
    fun _operationTypes(): AdminPresentationOperationTypesWrapper? {
        val anno =  annotation.cacheGet(OPERATION_TYPES_KEY, { resolveAnnotation(OPERATION_TYPES) })
        if(anno != null){
            return AdminPresentationOperationTypesWrapper(anno)
        }
        return null
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

    fun overrideValue(): Pair<PsiElement, String>? {
        return annotation.cacheGet(OVERRIDE_VALUE_KEY, { resolveDeclaredString(OVERRIDE_VALUE) })
    }
    
    fun _overrideValue(): Pair<PsiElement, String>? {
        return annotation.cacheGet(OVERRIDE_VALUE_KEY, { resolveString(OVERRIDE_VALUE) })
    }

    fun propertyType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PROPERTY_TYPE_KEY, { resolveDeclaredString(PROPERTY_TYPE) })
    }
    
    fun _propertyType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PROPERTY_TYPE_KEY, { resolveString(PROPERTY_TYPE) })
    }

    fun showIfFieldEquals(): List<FieldValueConfigurationWrapper> {
        val anno = annotation.cacheGet(SHOW_IF_FIELD_EQUALS_KEY, { resolveDeclaredAnnotationArray(SHOW_IF_FIELD_EQUALS) })
        if(anno != null){
            return anno.map{ FieldValueConfigurationWrapper(it) }
        }
        return emptyList<FieldValueConfigurationWrapper>()
    }
    
    fun _showIfFieldEquals(): List<FieldValueConfigurationWrapper> {
        val anno =  annotation.cacheGet(SHOW_IF_FIELD_EQUALS_KEY, { resolveAnnotationArray(SHOW_IF_FIELD_EQUALS) })
        if(anno != null){
            return anno.map{ FieldValueConfigurationWrapper(it) }
        }
        return emptyList<FieldValueConfigurationWrapper>()
    }

    fun stringArrayOverrideValue(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(STRING_ARRAY_OVERRIDE_VALUE_KEY, { resolveDeclaredStringArray(STRING_ARRAY_OVERRIDE_VALUE) })
    }
    
    fun _stringArrayOverrideValue(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(STRING_ARRAY_OVERRIDE_VALUE_KEY, { resolveStringArray(STRING_ARRAY_OVERRIDE_VALUE) })
    }

    fun validationConfigurations(): List<ValidationConfigurationWrapper> {
        val anno = annotation.cacheGet(VALIDATION_CONFIGURATIONS_KEY, { resolveDeclaredAnnotationArray(VALIDATION_CONFIGURATIONS) })
        if(anno != null){
            return anno.map{ ValidationConfigurationWrapper(it) }
        }
        return emptyList<ValidationConfigurationWrapper>()
    }
    
    fun _validationConfigurations(): List<ValidationConfigurationWrapper> {
        val anno =  annotation.cacheGet(VALIDATION_CONFIGURATIONS_KEY, { resolveAnnotationArray(VALIDATION_CONFIGURATIONS) })
        if(anno != null){
            return anno.map{ ValidationConfigurationWrapper(it) }
        }
        return emptyList<ValidationConfigurationWrapper>()
    }

}