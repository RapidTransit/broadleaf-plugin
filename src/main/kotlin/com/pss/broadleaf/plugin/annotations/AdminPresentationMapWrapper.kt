package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationMapWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMap"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationMap")
        val ADD_FRIENDLY_NAME = "addFriendlyName" 
        val CURRENCY_CODE_FIELD = "currencyCodeField" 
        val CUSTOM_CRITERIA = "customCriteria" 
        val DELETE_ENTITY_UPON_REMOVE = "deleteEntityUponRemove" 
        val EXCLUDED = "excluded" 
        val FORCE_FREE_FORM_KEYS = "forceFreeFormKeys" 
        val FRIENDLY_NAME = "friendlyName" 
        val GROUP = "group" 
        val IS_SIMPLE_VALUE = "isSimpleValue" 
        val KEY_CLASS = "keyClass" 
        val KEY_PROPERTY_FRIENDLY_NAME = "keyPropertyFriendlyName" 
        val KEYS = "keys" 
        val LAZY_FETCH = "lazyFetch" 
        val MANUAL_FETCH = "manualFetch" 
        val MANY_TO_FIELD = "manyToField" 
        val MAP_KEY_OPTION_ENTITY_CLASS = "mapKeyOptionEntityClass" 
        val MAP_KEY_OPTION_ENTITY_DISPLAY_FIELD = "mapKeyOptionEntityDisplayField" 
        val MAP_KEY_OPTION_ENTITY_VALUE_FIELD = "mapKeyOptionEntityValueField" 
        val MAP_KEY_VALUE_PROPERTY = "mapKeyValueProperty" 
        val MEDIA_FIELD = "mediaField" 
        val OPERATION_TYPES = "operationTypes" 
        val ORDER = "order" 
        val READ_ONLY = "readOnly" 
        val SECURITY_LEVEL = "securityLevel" 
        val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
        val SHOW_IF_PROPERTY = "showIfProperty" 
        val TAB = "tab" 
        val TAB_ORDER = "tabOrder" 
        val TO_ONE_PARENT_PROPERTY = "toOneParentProperty" 
        val TO_ONE_TARGET_PROPERTY = "toOneTargetProperty" 
        val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
        val VALUE_CLASS = "valueClass" 
        val VALUE_PROPERTY_FRIENDLY_NAME = "valuePropertyFriendlyName" 

        val ADD_FRIENDLY_NAME_KEY = Key<Pair<PsiElement, String>?>("@addFriendlyName")
        val CURRENCY_CODE_FIELD_KEY = Key<Pair<PsiElement, String>?>("@currencyCodeField")
        val CUSTOM_CRITERIA_KEY = Key<List<Pair<PsiElement, String>>>("@customCriteria")
        val DELETE_ENTITY_UPON_REMOVE_KEY = Key<Pair<PsiElement, Boolean>?>("@deleteEntityUponRemove")
        val EXCLUDED_KEY = Key<Pair<PsiElement, Boolean>?>("@excluded")
        val FORCE_FREE_FORM_KEYS_KEY = Key<Pair<PsiElement, Boolean>?>("@forceFreeFormKeys")
        val FRIENDLY_NAME_KEY = Key<Pair<PsiElement, String>?>("@friendlyName")
        val GROUP_KEY = Key<Pair<PsiElement, String>?>("@group")
        val IS_SIMPLE_VALUE_KEY = Key<Pair<PsiElement, String>?>("@isSimpleValue")
        val KEY_PROPERTY_FRIENDLY_NAME_KEY = Key<Pair<PsiElement, String>?>("@keyPropertyFriendlyName")
        val KEYS_KEY = Key<List<PsiAnnotation>?>("@keys")
        val LAZY_FETCH_KEY = Key<Pair<PsiElement, Boolean>?>("@lazyFetch")
        val MANUAL_FETCH_KEY = Key<Pair<PsiElement, Boolean>?>("@manualFetch")
        val MANY_TO_FIELD_KEY = Key<Pair<PsiElement, String>?>("@manyToField")
        val MAP_KEY_OPTION_ENTITY_DISPLAY_FIELD_KEY = Key<Pair<PsiElement, String>?>("@mapKeyOptionEntityDisplayField")
        val MAP_KEY_OPTION_ENTITY_VALUE_FIELD_KEY = Key<Pair<PsiElement, String>?>("@mapKeyOptionEntityValueField")
        val MAP_KEY_VALUE_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@mapKeyValueProperty")
        val MEDIA_FIELD_KEY = Key<Pair<PsiElement, String>?>("@mediaField")
        val OPERATION_TYPES_KEY = Key<PsiAnnotation?>("@operationTypes")
        val ORDER_KEY = Key<Pair<PsiElement, Int>?>("@order")
        val READ_ONLY_KEY = Key<Pair<PsiElement, Boolean>?>("@readOnly")
        val SECURITY_LEVEL_KEY = Key<Pair<PsiElement, String>?>("@securityLevel")
        val SHOW_IF_FIELD_EQUALS_KEY = Key<List<PsiAnnotation>?>("@showIfFieldEquals")
        val SHOW_IF_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@showIfProperty")
        val TAB_KEY = Key<Pair<PsiElement, String>?>("@tab")
        val TAB_ORDER_KEY = Key<Pair<PsiElement, Int>?>("@tabOrder")
        val TO_ONE_PARENT_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@toOneParentProperty")
        val TO_ONE_TARGET_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@toOneTargetProperty")
        val USE_SERVER_SIDE_INSPECTION_CACHE_KEY = Key<Pair<PsiElement, Boolean>?>("@useServerSideInspectionCache")
        val VALUE_PROPERTY_FRIENDLY_NAME_KEY = Key<Pair<PsiElement, String>?>("@valuePropertyFriendlyName")
    }


    fun addFriendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ADD_FRIENDLY_NAME_KEY, { resolveDeclaredString(ADD_FRIENDLY_NAME) })
    }
    
    fun _addFriendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ADD_FRIENDLY_NAME_KEY, { resolveString(ADD_FRIENDLY_NAME) })
    }

    fun currencyCodeField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(CURRENCY_CODE_FIELD_KEY, { resolveDeclaredString(CURRENCY_CODE_FIELD) })
    }
    
    fun _currencyCodeField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(CURRENCY_CODE_FIELD_KEY, { resolveString(CURRENCY_CODE_FIELD) })
    }

    fun customCriteria(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(CUSTOM_CRITERIA_KEY, { resolveDeclaredStringArray(CUSTOM_CRITERIA) })
    }
    
    fun _customCriteria(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(CUSTOM_CRITERIA_KEY, { resolveStringArray(CUSTOM_CRITERIA) })
    }

    fun deleteEntityUponRemove(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(DELETE_ENTITY_UPON_REMOVE_KEY, { resolveDeclaredBoolean(DELETE_ENTITY_UPON_REMOVE) })
    }
    
    fun _deleteEntityUponRemove(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(DELETE_ENTITY_UPON_REMOVE_KEY, { resolveBoolean(DELETE_ENTITY_UPON_REMOVE) })
    }

    fun excluded(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(EXCLUDED_KEY, { resolveDeclaredBoolean(EXCLUDED) })
    }
    
    fun _excluded(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(EXCLUDED_KEY, { resolveBoolean(EXCLUDED) })
    }

    fun forceFreeFormKeys(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(FORCE_FREE_FORM_KEYS_KEY, { resolveDeclaredBoolean(FORCE_FREE_FORM_KEYS) })
    }
    
    fun _forceFreeFormKeys(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(FORCE_FREE_FORM_KEYS_KEY, { resolveBoolean(FORCE_FREE_FORM_KEYS) })
    }

    fun friendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_NAME_KEY, { resolveDeclaredString(FRIENDLY_NAME) })
    }
    
    fun _friendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_NAME_KEY, { resolveString(FRIENDLY_NAME) })
    }

    fun group(): Pair<PsiElement, String>? {
        return annotation.cacheGet(GROUP_KEY, { resolveDeclaredString(GROUP) })
    }
    
    fun _group(): Pair<PsiElement, String>? {
        return annotation.cacheGet(GROUP_KEY, { resolveString(GROUP) })
    }

    fun isSimpleValue(): Pair<PsiElement, String>? {
        return annotation.cacheGet(IS_SIMPLE_VALUE_KEY, { resolveDeclaredEnum(IS_SIMPLE_VALUE) })
    }
    
    fun _isSimpleValue(): Pair<PsiElement, String>? {
        return annotation.cacheGet(IS_SIMPLE_VALUE_KEY, { resolveEnum(IS_SIMPLE_VALUE) })
    }

    fun keyPropertyFriendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(KEY_PROPERTY_FRIENDLY_NAME_KEY, { resolveDeclaredString(KEY_PROPERTY_FRIENDLY_NAME) })
    }
    
    fun _keyPropertyFriendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(KEY_PROPERTY_FRIENDLY_NAME_KEY, { resolveString(KEY_PROPERTY_FRIENDLY_NAME) })
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

    fun lazyFetch(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(LAZY_FETCH_KEY, { resolveDeclaredBoolean(LAZY_FETCH) })
    }
    
    fun _lazyFetch(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(LAZY_FETCH_KEY, { resolveBoolean(LAZY_FETCH) })
    }

    fun manualFetch(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(MANUAL_FETCH_KEY, { resolveDeclaredBoolean(MANUAL_FETCH) })
    }
    
    fun _manualFetch(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(MANUAL_FETCH_KEY, { resolveBoolean(MANUAL_FETCH) })
    }

    fun manyToField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MANY_TO_FIELD_KEY, { resolveDeclaredString(MANY_TO_FIELD) })
    }
    
    fun _manyToField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MANY_TO_FIELD_KEY, { resolveString(MANY_TO_FIELD) })
    }

    fun mapKeyOptionEntityDisplayField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MAP_KEY_OPTION_ENTITY_DISPLAY_FIELD_KEY, { resolveDeclaredString(MAP_KEY_OPTION_ENTITY_DISPLAY_FIELD) })
    }
    
    fun _mapKeyOptionEntityDisplayField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MAP_KEY_OPTION_ENTITY_DISPLAY_FIELD_KEY, { resolveString(MAP_KEY_OPTION_ENTITY_DISPLAY_FIELD) })
    }

    fun mapKeyOptionEntityValueField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MAP_KEY_OPTION_ENTITY_VALUE_FIELD_KEY, { resolveDeclaredString(MAP_KEY_OPTION_ENTITY_VALUE_FIELD) })
    }
    
    fun _mapKeyOptionEntityValueField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MAP_KEY_OPTION_ENTITY_VALUE_FIELD_KEY, { resolveString(MAP_KEY_OPTION_ENTITY_VALUE_FIELD) })
    }

    fun mapKeyValueProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MAP_KEY_VALUE_PROPERTY_KEY, { resolveDeclaredString(MAP_KEY_VALUE_PROPERTY) })
    }
    
    fun _mapKeyValueProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MAP_KEY_VALUE_PROPERTY_KEY, { resolveString(MAP_KEY_VALUE_PROPERTY) })
    }

    fun mediaField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MEDIA_FIELD_KEY, { resolveDeclaredString(MEDIA_FIELD) })
    }
    
    fun _mediaField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(MEDIA_FIELD_KEY, { resolveString(MEDIA_FIELD) })
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

    fun order(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(ORDER_KEY, { resolveDeclaredInteger(ORDER) })
    }
    
    fun _order(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(ORDER_KEY, { resolveInteger(ORDER) })
    }

    fun readOnly(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(READ_ONLY_KEY, { resolveDeclaredBoolean(READ_ONLY) })
    }
    
    fun _readOnly(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(READ_ONLY_KEY, { resolveBoolean(READ_ONLY) })
    }

    fun securityLevel(): Pair<PsiElement, String>? {
        return annotation.cacheGet(SECURITY_LEVEL_KEY, { resolveDeclaredString(SECURITY_LEVEL) })
    }
    
    fun _securityLevel(): Pair<PsiElement, String>? {
        return annotation.cacheGet(SECURITY_LEVEL_KEY, { resolveString(SECURITY_LEVEL) })
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

    fun showIfProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(SHOW_IF_PROPERTY_KEY, { resolveDeclaredString(SHOW_IF_PROPERTY) })
    }
    
    fun _showIfProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(SHOW_IF_PROPERTY_KEY, { resolveString(SHOW_IF_PROPERTY) })
    }

    fun tab(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TAB_KEY, { resolveDeclaredString(TAB) })
    }
    
    fun _tab(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TAB_KEY, { resolveString(TAB) })
    }

    fun tabOrder(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(TAB_ORDER_KEY, { resolveDeclaredInteger(TAB_ORDER) })
    }
    
    fun _tabOrder(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(TAB_ORDER_KEY, { resolveInteger(TAB_ORDER) })
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

    fun useServerSideInspectionCache(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(USE_SERVER_SIDE_INSPECTION_CACHE_KEY, { resolveDeclaredBoolean(USE_SERVER_SIDE_INSPECTION_CACHE) })
    }
    
    fun _useServerSideInspectionCache(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(USE_SERVER_SIDE_INSPECTION_CACHE_KEY, { resolveBoolean(USE_SERVER_SIDE_INSPECTION_CACHE) })
    }

    fun valuePropertyFriendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(VALUE_PROPERTY_FRIENDLY_NAME_KEY, { resolveDeclaredString(VALUE_PROPERTY_FRIENDLY_NAME) })
    }
    
    fun _valuePropertyFriendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(VALUE_PROPERTY_FRIENDLY_NAME_KEY, { resolveString(VALUE_PROPERTY_FRIENDLY_NAME) })
    }

}