package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationAdornedTargetCollectionWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection")
        val ADD_TYPE = "addType" 
        val CURRENCY_CODE_FIELD = "currencyCodeField" 
        val CUSTOM_CRITERIA = "customCriteria" 
        val EXCLUDED = "excluded" 
        val FRIENDLY_NAME = "friendlyName" 
        val GRID_VISIBLE_FIELDS = "gridVisibleFields" 
        val GROUP = "group" 
        val IGNORE_ADORNED_PROPERTIES = "ignoreAdornedProperties" 
        val JOIN_ENTITY_CLASS = "joinEntityClass" 
        val LAZY_FETCH = "lazyFetch" 
        val MAINTAINED_ADORNED_TARGET_FIELDS = "maintainedAdornedTargetFields" 
        val MANUAL_FETCH = "manualFetch" 
        val OPERATION_TYPES = "operationTypes" 
        val ORDER = "order" 
        val PARENT_OBJECT_ID_PROPERTY = "parentObjectIdProperty" 
        val PARENT_OBJECT_PROPERTY = "parentObjectProperty" 
        val READ_ONLY = "readOnly" 
        val SECURITY_LEVEL = "securityLevel" 
        val SELECTIZE_VISIBLE_FIELD = "selectizeVisibleField" 
        val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
        val SHOW_IF_PROPERTY = "showIfProperty" 
        val SORT_ASCENDING = "sortAscending" 
        val SORT_PROPERTY = "sortProperty" 
        val TAB = "tab" 
        val TAB_ORDER = "tabOrder" 
        val TARGET_OBJECT_ID_PROPERTY = "targetObjectIdProperty" 
        val TARGET_OBJECT_PROPERTY = "targetObjectProperty" 
        val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 

        val ADD_TYPE_KEY = Key<Pair<PsiElement, String>?>("@addType")
        val CURRENCY_CODE_FIELD_KEY = Key<Pair<PsiElement, String>?>("@currencyCodeField")
        val CUSTOM_CRITERIA_KEY = Key<List<Pair<PsiElement, String>>>("@customCriteria")
        val EXCLUDED_KEY = Key<Pair<PsiElement, Boolean>?>("@excluded")
        val FRIENDLY_NAME_KEY = Key<Pair<PsiElement, String>?>("@friendlyName")
        val GRID_VISIBLE_FIELDS_KEY = Key<List<Pair<PsiElement, String>>>("@gridVisibleFields")
        val GROUP_KEY = Key<Pair<PsiElement, String>?>("@group")
        val IGNORE_ADORNED_PROPERTIES_KEY = Key<Pair<PsiElement, Boolean>?>("@ignoreAdornedProperties")
        val JOIN_ENTITY_CLASS_KEY = Key<Pair<PsiElement, String>?>("@joinEntityClass")
        val LAZY_FETCH_KEY = Key<Pair<PsiElement, Boolean>?>("@lazyFetch")
        val MAINTAINED_ADORNED_TARGET_FIELDS_KEY = Key<List<Pair<PsiElement, String>>>("@maintainedAdornedTargetFields")
        val MANUAL_FETCH_KEY = Key<Pair<PsiElement, Boolean>?>("@manualFetch")
        val OPERATION_TYPES_KEY = Key<PsiAnnotation?>("@operationTypes")
        val ORDER_KEY = Key<Pair<PsiElement, Int>?>("@order")
        val PARENT_OBJECT_ID_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@parentObjectIdProperty")
        val PARENT_OBJECT_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@parentObjectProperty")
        val READ_ONLY_KEY = Key<Pair<PsiElement, Boolean>?>("@readOnly")
        val SECURITY_LEVEL_KEY = Key<Pair<PsiElement, String>?>("@securityLevel")
        val SELECTIZE_VISIBLE_FIELD_KEY = Key<Pair<PsiElement, String>?>("@selectizeVisibleField")
        val SHOW_IF_FIELD_EQUALS_KEY = Key<List<PsiAnnotation>?>("@showIfFieldEquals")
        val SHOW_IF_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@showIfProperty")
        val SORT_ASCENDING_KEY = Key<Pair<PsiElement, Boolean>?>("@sortAscending")
        val SORT_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@sortProperty")
        val TAB_KEY = Key<Pair<PsiElement, String>?>("@tab")
        val TAB_ORDER_KEY = Key<Pair<PsiElement, Int>?>("@tabOrder")
        val TARGET_OBJECT_ID_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@targetObjectIdProperty")
        val TARGET_OBJECT_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@targetObjectProperty")
        val USE_SERVER_SIDE_INSPECTION_CACHE_KEY = Key<Pair<PsiElement, Boolean>?>("@useServerSideInspectionCache")
    }


    fun addType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ADD_TYPE_KEY, { resolveDeclaredEnum(ADD_TYPE) })
    }
    
    fun _addType(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ADD_TYPE_KEY, { resolveEnum(ADD_TYPE) })
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

    fun excluded(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(EXCLUDED_KEY, { resolveDeclaredBoolean(EXCLUDED) })
    }
    
    fun _excluded(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(EXCLUDED_KEY, { resolveBoolean(EXCLUDED) })
    }

    fun friendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_NAME_KEY, { resolveDeclaredString(FRIENDLY_NAME) })
    }
    
    fun _friendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_NAME_KEY, { resolveString(FRIENDLY_NAME) })
    }

    fun gridVisibleFields(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(GRID_VISIBLE_FIELDS_KEY, { resolveDeclaredStringArray(GRID_VISIBLE_FIELDS) })
    }
    
    fun _gridVisibleFields(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(GRID_VISIBLE_FIELDS_KEY, { resolveStringArray(GRID_VISIBLE_FIELDS) })
    }

    fun group(): Pair<PsiElement, String>? {
        return annotation.cacheGet(GROUP_KEY, { resolveDeclaredString(GROUP) })
    }
    
    fun _group(): Pair<PsiElement, String>? {
        return annotation.cacheGet(GROUP_KEY, { resolveString(GROUP) })
    }

    fun ignoreAdornedProperties(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(IGNORE_ADORNED_PROPERTIES_KEY, { resolveDeclaredBoolean(IGNORE_ADORNED_PROPERTIES) })
    }
    
    fun _ignoreAdornedProperties(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(IGNORE_ADORNED_PROPERTIES_KEY, { resolveBoolean(IGNORE_ADORNED_PROPERTIES) })
    }

    fun joinEntityClass(): Pair<PsiElement, String>? {
        return annotation.cacheGet(JOIN_ENTITY_CLASS_KEY, { resolveDeclaredString(JOIN_ENTITY_CLASS) })
    }
    
    fun _joinEntityClass(): Pair<PsiElement, String>? {
        return annotation.cacheGet(JOIN_ENTITY_CLASS_KEY, { resolveString(JOIN_ENTITY_CLASS) })
    }

    fun lazyFetch(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(LAZY_FETCH_KEY, { resolveDeclaredBoolean(LAZY_FETCH) })
    }
    
    fun _lazyFetch(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(LAZY_FETCH_KEY, { resolveBoolean(LAZY_FETCH) })
    }

    fun maintainedAdornedTargetFields(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(MAINTAINED_ADORNED_TARGET_FIELDS_KEY, { resolveDeclaredStringArray(MAINTAINED_ADORNED_TARGET_FIELDS) })
    }
    
    fun _maintainedAdornedTargetFields(): List<Pair<PsiElement, String>> {
        return annotation.cacheGet(MAINTAINED_ADORNED_TARGET_FIELDS_KEY, { resolveStringArray(MAINTAINED_ADORNED_TARGET_FIELDS) })
    }

    fun manualFetch(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(MANUAL_FETCH_KEY, { resolveDeclaredBoolean(MANUAL_FETCH) })
    }
    
    fun _manualFetch(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(MANUAL_FETCH_KEY, { resolveBoolean(MANUAL_FETCH) })
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

    fun parentObjectIdProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PARENT_OBJECT_ID_PROPERTY_KEY, { resolveDeclaredString(PARENT_OBJECT_ID_PROPERTY) })
    }
    
    fun _parentObjectIdProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PARENT_OBJECT_ID_PROPERTY_KEY, { resolveString(PARENT_OBJECT_ID_PROPERTY) })
    }

    fun parentObjectProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PARENT_OBJECT_PROPERTY_KEY, { resolveDeclaredString(PARENT_OBJECT_PROPERTY) })
    }
    
    fun _parentObjectProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PARENT_OBJECT_PROPERTY_KEY, { resolveString(PARENT_OBJECT_PROPERTY) })
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

    fun selectizeVisibleField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(SELECTIZE_VISIBLE_FIELD_KEY, { resolveDeclaredString(SELECTIZE_VISIBLE_FIELD) })
    }
    
    fun _selectizeVisibleField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(SELECTIZE_VISIBLE_FIELD_KEY, { resolveString(SELECTIZE_VISIBLE_FIELD) })
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

    fun sortAscending(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(SORT_ASCENDING_KEY, { resolveDeclaredBoolean(SORT_ASCENDING) })
    }
    
    fun _sortAscending(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(SORT_ASCENDING_KEY, { resolveBoolean(SORT_ASCENDING) })
    }

    fun sortProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(SORT_PROPERTY_KEY, { resolveDeclaredString(SORT_PROPERTY) })
    }
    
    fun _sortProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(SORT_PROPERTY_KEY, { resolveString(SORT_PROPERTY) })
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

    fun targetObjectIdProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TARGET_OBJECT_ID_PROPERTY_KEY, { resolveDeclaredString(TARGET_OBJECT_ID_PROPERTY) })
    }
    
    fun _targetObjectIdProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TARGET_OBJECT_ID_PROPERTY_KEY, { resolveString(TARGET_OBJECT_ID_PROPERTY) })
    }

    fun targetObjectProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TARGET_OBJECT_PROPERTY_KEY, { resolveDeclaredString(TARGET_OBJECT_PROPERTY) })
    }
    
    fun _targetObjectProperty(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TARGET_OBJECT_PROPERTY_KEY, { resolveString(TARGET_OBJECT_PROPERTY) })
    }

    fun useServerSideInspectionCache(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(USE_SERVER_SIDE_INSPECTION_CACHE_KEY, { resolveDeclaredBoolean(USE_SERVER_SIDE_INSPECTION_CACHE) })
    }
    
    fun _useServerSideInspectionCache(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(USE_SERVER_SIDE_INSPECTION_CACHE_KEY, { resolveBoolean(USE_SERVER_SIDE_INSPECTION_CACHE) })
    }

}