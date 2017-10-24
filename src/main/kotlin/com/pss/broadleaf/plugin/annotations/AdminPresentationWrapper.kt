package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentation"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminPresentation")
        val ADD_FRIENDLY_NAME = "addFriendlyName" 
        val ALLOW_NO_VALUE_ENUM_OPTION = "allowNoValueEnumOption" 
        val ASSOCIATED_FIELD_NAME = "associatedFieldName" 
        val BROADLEAF_ENUMERATION = "broadleafEnumeration" 
        val CAN_LINK_TO_EXTERNAL_ENTITY = "canLinkToExternalEntity" 
        val COLUMN_WIDTH = "columnWidth" 
        val CURRENCY_CODE_FIELD = "currencyCodeField" 
        val DEFAULT_VALUE = "defaultValue" 
        val DISPLAY_TYPE = "displayType" 
        val EXCLUDED = "excluded" 
        val FIELD_COMPONENT_RENDERER = "fieldComponentRenderer" 
        val FIELD_TYPE = "fieldType" 
        val FRIENDLY_NAME = "friendlyName" 
        val GRID_ORDER = "gridOrder" 
        val GROUP = "group" 
        val GROUP_COLLAPSED = "groupCollapsed" 
        val GROUP_ORDER = "groupOrder" 
        val HELP_TEXT = "helpText" 
        val HIDE_ENUMERATION_IF_EMPTY = "hideEnumerationIfEmpty" 
        val HINT = "hint" 
        val LARGE_ENTRY = "largeEntry" 
        val ORDER = "order" 
        val PROMINENT = "prominent" 
        val READ_ONLY = "readOnly" 
        val REQUIRED_OVERRIDE = "requiredOverride" 
        val RULE_IDENTIFIER = "ruleIdentifier" 
        val SECURITY_LEVEL = "securityLevel" 
        val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
        val SHOW_IF_PROPERTY = "showIfProperty" 
        val TAB = "tab" 
        val TAB_ORDER = "tabOrder" 
        val TOOLTIP = "tooltip" 
        val TRANSLATABLE = "translatable" 
        val VALIDATION_CONFIGURATIONS = "validationConfigurations" 
        val VISIBILITY = "visibility" 

        val INVOKERS = mapOf<String, (AdminPresentationWrapper)->Any?>(Pair("addFriendlyName", {wrapper-> wrapper.addFriendlyName() }) , Pair("allowNoValueEnumOption", {wrapper-> wrapper.allowNoValueEnumOption() }) , Pair("associatedFieldName", {wrapper-> wrapper.associatedFieldName() }) , Pair("broadleafEnumeration", {wrapper-> wrapper.broadleafEnumeration() }) , Pair("canLinkToExternalEntity", {wrapper-> wrapper.canLinkToExternalEntity() }) , Pair("columnWidth", {wrapper-> wrapper.columnWidth() }) , Pair("currencyCodeField", {wrapper-> wrapper.currencyCodeField() }) , Pair("defaultValue", {wrapper-> wrapper.defaultValue() }) , Pair("displayType", {wrapper-> wrapper.displayType() }) , Pair("excluded", {wrapper-> wrapper.excluded() }) , Pair("fieldComponentRenderer", {wrapper-> wrapper.fieldComponentRenderer() }) , Pair("fieldType", {wrapper-> wrapper.fieldType() }) , Pair("friendlyName", {wrapper-> wrapper.friendlyName() }) , Pair("gridOrder", {wrapper-> wrapper.gridOrder() }) , Pair("group", {wrapper-> wrapper.group() }) , Pair("groupCollapsed", {wrapper-> wrapper.groupCollapsed() }) , Pair("groupOrder", {wrapper-> wrapper.groupOrder() }) , Pair("helpText", {wrapper-> wrapper.helpText() }) , Pair("hideEnumerationIfEmpty", {wrapper-> wrapper.hideEnumerationIfEmpty() }) , Pair("hint", {wrapper-> wrapper.hint() }) , Pair("largeEntry", {wrapper-> wrapper.largeEntry() }) , Pair("order", {wrapper-> wrapper.order() }) , Pair("prominent", {wrapper-> wrapper.prominent() }) , Pair("readOnly", {wrapper-> wrapper.readOnly() }) , Pair("requiredOverride", {wrapper-> wrapper.requiredOverride() }) , Pair("ruleIdentifier", {wrapper-> wrapper.ruleIdentifier() }) , Pair("securityLevel", {wrapper-> wrapper.securityLevel() }) , Pair("showIfFieldEquals", {wrapper-> wrapper.showIfFieldEquals() }) , Pair("showIfProperty", {wrapper-> wrapper.showIfProperty() }) , Pair("tab", {wrapper-> wrapper.tab() }) , Pair("tabOrder", {wrapper-> wrapper.tabOrder() }) , Pair("tooltip", {wrapper-> wrapper.tooltip() }) , Pair("translatable", {wrapper-> wrapper.translatable() }) , Pair("validationConfigurations", {wrapper-> wrapper.validationConfigurations() }) , Pair("visibility", {wrapper-> wrapper.visibility() }) )
        val METHODS = mapOf<String, Class<out Any>>(Pair("addFriendlyName", String::class.java), Pair("allowNoValueEnumOption", Boolean::class.javaPrimitiveType!!), Pair("associatedFieldName", String::class.java), Pair("broadleafEnumeration", String::class.java), Pair("canLinkToExternalEntity", Boolean::class.javaPrimitiveType!!), Pair("columnWidth", String::class.java), Pair("currencyCodeField", String::class.java), Pair("defaultValue", String::class.java), Pair("displayType", Enum::class.java), Pair("excluded", Boolean::class.javaPrimitiveType!!), Pair("fieldComponentRenderer", Enum::class.java), Pair("fieldType", Enum::class.java), Pair("friendlyName", String::class.java), Pair("gridOrder", Int::class.javaPrimitiveType!!), Pair("group", String::class.java), Pair("groupCollapsed", Boolean::class.javaPrimitiveType!!), Pair("groupOrder", Int::class.javaPrimitiveType!!), Pair("helpText", String::class.java), Pair("hideEnumerationIfEmpty", Boolean::class.javaPrimitiveType!!), Pair("hint", String::class.java), Pair("largeEntry", Boolean::class.javaPrimitiveType!!), Pair("order", Int::class.javaPrimitiveType!!), Pair("prominent", Boolean::class.javaPrimitiveType!!), Pair("readOnly", Boolean::class.javaPrimitiveType!!), Pair("requiredOverride", Enum::class.java), Pair("ruleIdentifier", String::class.java), Pair("securityLevel", String::class.java), Pair("showIfFieldEquals)", Array<Annotation>::class.java), Pair("showIfProperty", String::class.java), Pair("tab", String::class.java), Pair("tabOrder", Int::class.javaPrimitiveType!!), Pair("tooltip", String::class.java), Pair("translatable", Boolean::class.javaPrimitiveType!!), Pair("validationConfigurations)", Array<Annotation>::class.java), Pair("visibility", Enum::class.java))
        val ADD_FRIENDLY_NAME_KEY = Key<Pair<PsiElement, String>?>("@addFriendlyName")
        val ALLOW_NO_VALUE_ENUM_OPTION_KEY = Key<Pair<PsiElement, Boolean>?>("@allowNoValueEnumOption")
        val ASSOCIATED_FIELD_NAME_KEY = Key<Pair<PsiElement, String>?>("@associatedFieldName")
        val BROADLEAF_ENUMERATION_KEY = Key<Pair<PsiElement, String>?>("@broadleafEnumeration")
        val CAN_LINK_TO_EXTERNAL_ENTITY_KEY = Key<Pair<PsiElement, Boolean>?>("@canLinkToExternalEntity")
        val COLUMN_WIDTH_KEY = Key<Pair<PsiElement, String>?>("@columnWidth")
        val CURRENCY_CODE_FIELD_KEY = Key<Pair<PsiElement, String>?>("@currencyCodeField")
        val DEFAULT_VALUE_KEY = Key<Pair<PsiElement, String>?>("@defaultValue")
        val DISPLAY_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@displayType")
        val EXCLUDED_KEY = Key<Pair<PsiElement, Boolean>?>("@excluded")
        val FIELD_COMPONENT_RENDERER_KEY = Key<Pair<PsiElement, PsiField>?>("@fieldComponentRenderer")
        val FIELD_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@fieldType")
        val FRIENDLY_NAME_KEY = Key<Pair<PsiElement, String>?>("@friendlyName")
        val GRID_ORDER_KEY = Key<Pair<PsiElement, Int>?>("@gridOrder")
        val GROUP_KEY = Key<Pair<PsiElement, String>?>("@group")
        val GROUP_COLLAPSED_KEY = Key<Pair<PsiElement, Boolean>?>("@groupCollapsed")
        val GROUP_ORDER_KEY = Key<Pair<PsiElement, Int>?>("@groupOrder")
        val HELP_TEXT_KEY = Key<Pair<PsiElement, String>?>("@helpText")
        val HIDE_ENUMERATION_IF_EMPTY_KEY = Key<Pair<PsiElement, Boolean>?>("@hideEnumerationIfEmpty")
        val HINT_KEY = Key<Pair<PsiElement, String>?>("@hint")
        val LARGE_ENTRY_KEY = Key<Pair<PsiElement, Boolean>?>("@largeEntry")
        val ORDER_KEY = Key<Pair<PsiElement, Int>?>("@order")
        val PROMINENT_KEY = Key<Pair<PsiElement, Boolean>?>("@prominent")
        val READ_ONLY_KEY = Key<Pair<PsiElement, Boolean>?>("@readOnly")
        val REQUIRED_OVERRIDE_KEY = Key<Pair<PsiElement, PsiField>?>("@requiredOverride")
        val RULE_IDENTIFIER_KEY = Key<Pair<PsiElement, String>?>("@ruleIdentifier")
        val SECURITY_LEVEL_KEY = Key<Pair<PsiElement, String>?>("@securityLevel")
        val SHOW_IF_FIELD_EQUALS_KEY = Key<List<PsiAnnotation>?>("@showIfFieldEquals")
        val SHOW_IF_PROPERTY_KEY = Key<Pair<PsiElement, String>?>("@showIfProperty")
        val TAB_KEY = Key<Pair<PsiElement, String>?>("@tab")
        val TAB_ORDER_KEY = Key<Pair<PsiElement, Int>?>("@tabOrder")
        val TOOLTIP_KEY = Key<Pair<PsiElement, String>?>("@tooltip")
        val TRANSLATABLE_KEY = Key<Pair<PsiElement, Boolean>?>("@translatable")
        val VALIDATION_CONFIGURATIONS_KEY = Key<List<PsiAnnotation>?>("@validationConfigurations")
        val VISIBILITY_KEY = Key<Pair<PsiElement, PsiField>?>("@visibility")
    }


    override fun getMethods(): Map<String, Class<out Any>> {
        return METHODS
    }

    fun addFriendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ADD_FRIENDLY_NAME_KEY, { resolveDeclaredString(ADD_FRIENDLY_NAME) })
    }
    
    fun _addFriendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ADD_FRIENDLY_NAME_KEY, { resolveString(ADD_FRIENDLY_NAME) })
    }

    fun allowNoValueEnumOption(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(ALLOW_NO_VALUE_ENUM_OPTION_KEY, { resolveDeclaredBoolean(ALLOW_NO_VALUE_ENUM_OPTION) })
    }
    
    fun _allowNoValueEnumOption(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(ALLOW_NO_VALUE_ENUM_OPTION_KEY, { resolveBoolean(ALLOW_NO_VALUE_ENUM_OPTION) })
    }

    fun associatedFieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ASSOCIATED_FIELD_NAME_KEY, { resolveDeclaredString(ASSOCIATED_FIELD_NAME) })
    }
    
    fun _associatedFieldName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(ASSOCIATED_FIELD_NAME_KEY, { resolveString(ASSOCIATED_FIELD_NAME) })
    }

    fun broadleafEnumeration(): Pair<PsiElement, String>? {
        return annotation.cacheGet(BROADLEAF_ENUMERATION_KEY, { resolveDeclaredString(BROADLEAF_ENUMERATION) })
    }
    
    fun _broadleafEnumeration(): Pair<PsiElement, String>? {
        return annotation.cacheGet(BROADLEAF_ENUMERATION_KEY, { resolveString(BROADLEAF_ENUMERATION) })
    }

    fun canLinkToExternalEntity(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(CAN_LINK_TO_EXTERNAL_ENTITY_KEY, { resolveDeclaredBoolean(CAN_LINK_TO_EXTERNAL_ENTITY) })
    }
    
    fun _canLinkToExternalEntity(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(CAN_LINK_TO_EXTERNAL_ENTITY_KEY, { resolveBoolean(CAN_LINK_TO_EXTERNAL_ENTITY) })
    }

    fun columnWidth(): Pair<PsiElement, String>? {
        return annotation.cacheGet(COLUMN_WIDTH_KEY, { resolveDeclaredString(COLUMN_WIDTH) })
    }
    
    fun _columnWidth(): Pair<PsiElement, String>? {
        return annotation.cacheGet(COLUMN_WIDTH_KEY, { resolveString(COLUMN_WIDTH) })
    }

    fun currencyCodeField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(CURRENCY_CODE_FIELD_KEY, { resolveDeclaredString(CURRENCY_CODE_FIELD) })
    }
    
    fun _currencyCodeField(): Pair<PsiElement, String>? {
        return annotation.cacheGet(CURRENCY_CODE_FIELD_KEY, { resolveString(CURRENCY_CODE_FIELD) })
    }

    fun defaultValue(): Pair<PsiElement, String>? {
        return annotation.cacheGet(DEFAULT_VALUE_KEY, { resolveDeclaredString(DEFAULT_VALUE) })
    }
    
    fun _defaultValue(): Pair<PsiElement, String>? {
        return annotation.cacheGet(DEFAULT_VALUE_KEY, { resolveString(DEFAULT_VALUE) })
    }

    fun displayType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(DISPLAY_TYPE_KEY, { resolveDeclaredEnum(DISPLAY_TYPE) })
    }
    
    fun _displayType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(DISPLAY_TYPE_KEY, { resolveEnum(DISPLAY_TYPE) })
    }

    fun excluded(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(EXCLUDED_KEY, { resolveDeclaredBoolean(EXCLUDED) })
    }
    
    fun _excluded(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(EXCLUDED_KEY, { resolveBoolean(EXCLUDED) })
    }

    fun fieldComponentRenderer(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(FIELD_COMPONENT_RENDERER_KEY, { resolveDeclaredEnum(FIELD_COMPONENT_RENDERER) })
    }
    
    fun _fieldComponentRenderer(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(FIELD_COMPONENT_RENDERER_KEY, { resolveEnum(FIELD_COMPONENT_RENDERER) })
    }

    fun fieldType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(FIELD_TYPE_KEY, { resolveDeclaredEnum(FIELD_TYPE) })
    }
    
    fun _fieldType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(FIELD_TYPE_KEY, { resolveEnum(FIELD_TYPE) })
    }

    fun friendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_NAME_KEY, { resolveDeclaredString(FRIENDLY_NAME) })
    }
    
    fun _friendlyName(): Pair<PsiElement, String>? {
        return annotation.cacheGet(FRIENDLY_NAME_KEY, { resolveString(FRIENDLY_NAME) })
    }

    fun gridOrder(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(GRID_ORDER_KEY, { resolveDeclaredInt(GRID_ORDER) })
    }
    
    fun _gridOrder(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(GRID_ORDER_KEY, { resolveInt(GRID_ORDER) })
    }

    fun group(): Pair<PsiElement, String>? {
        return annotation.cacheGet(GROUP_KEY, { resolveDeclaredString(GROUP) })
    }
    
    fun _group(): Pair<PsiElement, String>? {
        return annotation.cacheGet(GROUP_KEY, { resolveString(GROUP) })
    }

    fun groupCollapsed(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(GROUP_COLLAPSED_KEY, { resolveDeclaredBoolean(GROUP_COLLAPSED) })
    }
    
    fun _groupCollapsed(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(GROUP_COLLAPSED_KEY, { resolveBoolean(GROUP_COLLAPSED) })
    }

    fun groupOrder(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(GROUP_ORDER_KEY, { resolveDeclaredInt(GROUP_ORDER) })
    }
    
    fun _groupOrder(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(GROUP_ORDER_KEY, { resolveInt(GROUP_ORDER) })
    }

    fun helpText(): Pair<PsiElement, String>? {
        return annotation.cacheGet(HELP_TEXT_KEY, { resolveDeclaredString(HELP_TEXT) })
    }
    
    fun _helpText(): Pair<PsiElement, String>? {
        return annotation.cacheGet(HELP_TEXT_KEY, { resolveString(HELP_TEXT) })
    }

    fun hideEnumerationIfEmpty(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(HIDE_ENUMERATION_IF_EMPTY_KEY, { resolveDeclaredBoolean(HIDE_ENUMERATION_IF_EMPTY) })
    }
    
    fun _hideEnumerationIfEmpty(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(HIDE_ENUMERATION_IF_EMPTY_KEY, { resolveBoolean(HIDE_ENUMERATION_IF_EMPTY) })
    }

    fun hint(): Pair<PsiElement, String>? {
        return annotation.cacheGet(HINT_KEY, { resolveDeclaredString(HINT) })
    }
    
    fun _hint(): Pair<PsiElement, String>? {
        return annotation.cacheGet(HINT_KEY, { resolveString(HINT) })
    }

    fun largeEntry(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(LARGE_ENTRY_KEY, { resolveDeclaredBoolean(LARGE_ENTRY) })
    }
    
    fun _largeEntry(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(LARGE_ENTRY_KEY, { resolveBoolean(LARGE_ENTRY) })
    }

    fun order(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(ORDER_KEY, { resolveDeclaredInt(ORDER) })
    }
    
    fun _order(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(ORDER_KEY, { resolveInt(ORDER) })
    }

    fun prominent(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(PROMINENT_KEY, { resolveDeclaredBoolean(PROMINENT) })
    }
    
    fun _prominent(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(PROMINENT_KEY, { resolveBoolean(PROMINENT) })
    }

    fun readOnly(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(READ_ONLY_KEY, { resolveDeclaredBoolean(READ_ONLY) })
    }
    
    fun _readOnly(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(READ_ONLY_KEY, { resolveBoolean(READ_ONLY) })
    }

    fun requiredOverride(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(REQUIRED_OVERRIDE_KEY, { resolveDeclaredEnum(REQUIRED_OVERRIDE) })
    }
    
    fun _requiredOverride(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(REQUIRED_OVERRIDE_KEY, { resolveEnum(REQUIRED_OVERRIDE) })
    }

    fun ruleIdentifier(): Pair<PsiElement, String>? {
        return annotation.cacheGet(RULE_IDENTIFIER_KEY, { resolveDeclaredString(RULE_IDENTIFIER) })
    }
    
    fun _ruleIdentifier(): Pair<PsiElement, String>? {
        return annotation.cacheGet(RULE_IDENTIFIER_KEY, { resolveString(RULE_IDENTIFIER) })
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
        return annotation.cacheGet(TAB_ORDER_KEY, { resolveDeclaredInt(TAB_ORDER) })
    }
    
    fun _tabOrder(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(TAB_ORDER_KEY, { resolveInt(TAB_ORDER) })
    }

    fun tooltip(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TOOLTIP_KEY, { resolveDeclaredString(TOOLTIP) })
    }
    
    fun _tooltip(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TOOLTIP_KEY, { resolveString(TOOLTIP) })
    }

    fun translatable(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(TRANSLATABLE_KEY, { resolveDeclaredBoolean(TRANSLATABLE) })
    }
    
    fun _translatable(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(TRANSLATABLE_KEY, { resolveBoolean(TRANSLATABLE) })
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

    fun visibility(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(VISIBILITY_KEY, { resolveDeclaredEnum(VISIBILITY) })
    }
    
    fun _visibility(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(VISIBILITY_KEY, { resolveEnum(VISIBILITY) })
    }

}