package com.pss.broadleaf.plugin

import java.util.*

object BroadleafConstants {

    object PresentationAnnotations {
        object AdminGroupPresentation {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminGroupPresentation"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminGroupPresentation")
            val COLUMN = "column" 
            val UNTITLED = "untitled" 
            val TOOLTIP = "tooltip" 
            val COLLAPSED = "collapsed" 
            val NAME = "name" 
            val ORDER = "order" 
        }

        object AdminPresentation {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentation"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentation")
            val VISIBILITY = "visibility" 
            val EXCLUDED = "excluded" 
            val HINT = "hint" 
            val ADD_FRIENDLY_NAME = "addFriendlyName" 
            val SECURITY_LEVEL = "securityLevel" 
            val SHOW_IF_PROPERTY = "showIfProperty" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val CURRENCY_CODE_FIELD = "currencyCodeField" 
            val GROUP_ORDER = "groupOrder" 
            val TAB_ORDER = "tabOrder" 
            val FRIENDLY_NAME = "friendlyName" 
            val DISPLAY_TYPE = "displayType" 
            val FIELD_COMPONENT_RENDERER = "fieldComponentRenderer" 
            val BROADLEAF_ENUMERATION = "broadleafEnumeration" 
            val CAN_LINK_TO_EXTERNAL_ENTITY = "canLinkToExternalEntity" 
            val ALLOW_NO_VALUE_ENUM_OPTION = "allowNoValueEnumOption" 
            val TOOLTIP = "tooltip" 
            val VALIDATION_CONFIGURATIONS = "validationConfigurations" 
            val HIDE_ENUMERATION_IF_EMPTY = "hideEnumerationIfEmpty" 
            val GROUP_COLLAPSED = "groupCollapsed" 
            val LARGE_ENTRY = "largeEntry" 
            val PROMINENT = "prominent" 
            val COLUMN_WIDTH = "columnWidth" 
            val REQUIRED_OVERRIDE = "requiredOverride" 
            val HELP_TEXT = "helpText" 
            val RULE_IDENTIFIER = "ruleIdentifier" 
            val TRANSLATABLE = "translatable" 
            val ASSOCIATED_FIELD_NAME = "associatedFieldName" 
            val GRID_ORDER = "gridOrder" 
            val READ_ONLY = "readOnly" 
            val TAB = "tab" 
            val DEFAULT_VALUE = "defaultValue" 
            val FIELD_TYPE = "fieldType" 
            val GROUP = "group" 
            val ORDER = "order" 
        }

        object AdminPresentationAdornedTargetCollection {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection")
            val EXCLUDED = "excluded" 
            val SECURITY_LEVEL = "securityLevel" 
            val MANUAL_FETCH = "manualFetch" 
            val SHOW_IF_PROPERTY = "showIfProperty" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val CURRENCY_CODE_FIELD = "currencyCodeField" 
            val LAZY_FETCH = "lazyFetch" 
            val TAB_ORDER = "tabOrder" 
            val FRIENDLY_NAME = "friendlyName" 
            val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
            val PARENT_OBJECT_PROPERTY = "parentObjectProperty" 
            val PARENT_OBJECT_ID_PROPERTY = "parentObjectIdProperty" 
            val TARGET_OBJECT_PROPERTY = "targetObjectProperty" 
            val MAINTAINED_ADORNED_TARGET_FIELDS = "maintainedAdornedTargetFields" 
            val GRID_VISIBLE_FIELDS = "gridVisibleFields" 
            val TARGET_OBJECT_ID_PROPERTY = "targetObjectIdProperty" 
            val IGNORE_ADORNED_PROPERTIES = "ignoreAdornedProperties" 
            val OPERATION_TYPES = "operationTypes" 
            val SELECTIZE_VISIBLE_FIELD = "selectizeVisibleField" 
            val JOIN_ENTITY_CLASS = "joinEntityClass" 
            val CUSTOM_CRITERIA = "customCriteria" 
            val SORT_ASCENDING = "sortAscending" 
            val SORT_PROPERTY = "sortProperty" 
            val ADD_TYPE = "addType" 
            val READ_ONLY = "readOnly" 
            val TAB = "tab" 
            val GROUP = "group" 
            val ORDER = "order" 
        }

        object AdminPresentationClass {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationClass"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationClass")
            val TABS = "tabs" 
            val FRIENDLY_NAME = "friendlyName" 
            val POPULATE_TO_ONE_FIELDS = "populateToOneFields" 
            val CEILING_DISPLAY_ENTITY = "ceilingDisplayEntity" 
            val EXCLUDE_FROM_POLYMORPHISM = "excludeFromPolymorphism" 
            val TAB_OVERRIDES = "tabOverrides" 
            val GROUP_OVERRIDES = "groupOverrides" 
        }

        object AdminPresentationCollection {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationCollection"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationCollection")
            val EXCLUDED = "excluded" 
            val ADD_FRIENDLY_NAME = "addFriendlyName" 
            val SECURITY_LEVEL = "securityLevel" 
            val MANUAL_FETCH = "manualFetch" 
            val SHOW_IF_PROPERTY = "showIfProperty" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val CURRENCY_CODE_FIELD = "currencyCodeField" 
            val LAZY_FETCH = "lazyFetch" 
            val TAB_ORDER = "tabOrder" 
            val FRIENDLY_NAME = "friendlyName" 
            val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
            val OPERATION_TYPES = "operationTypes" 
            val SELECTIZE_VISIBLE_FIELD = "selectizeVisibleField" 
            val MANY_TO_FIELD = "manyToField" 
            val CUSTOM_CRITERIA = "customCriteria" 
            val SORT_ASCENDING = "sortAscending" 
            val SORT_PROPERTY = "sortProperty" 
            val ADD_TYPE = "addType" 
            val READ_ONLY = "readOnly" 
            val TAB = "tab" 
            val GROUP = "group" 
            val ORDER = "order" 
        }

        object AdminPresentationDataDrivenEnumeration {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration")
            val OPTION_LIST_ENTITY = "optionListEntity" 
            val OPTION_FILTER_PARAMS = "optionFilterParams" 
            val OPTION_VALUE_FIELD_NAME = "optionValueFieldName" 
            val OPTION_DISPLAY_FIELD_NAME = "optionDisplayFieldName" 
            val OPTION_CAN_EDIT_VALUES = "optionCanEditValues" 
            val OPTION_HIDE_IF_EMPTY = "optionHideIfEmpty" 
        }

        object AdminPresentationMap {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMap"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationMap")
            val EXCLUDED = "excluded" 
            val ADD_FRIENDLY_NAME = "addFriendlyName" 
            val SECURITY_LEVEL = "securityLevel" 
            val MANUAL_FETCH = "manualFetch" 
            val SHOW_IF_PROPERTY = "showIfProperty" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val CURRENCY_CODE_FIELD = "currencyCodeField" 
            val LAZY_FETCH = "lazyFetch" 
            val TAB_ORDER = "tabOrder" 
            val FRIENDLY_NAME = "friendlyName" 
            val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
            val OPERATION_TYPES = "operationTypes" 
            val MANY_TO_FIELD = "manyToField" 
            val KEY_CLASS = "keyClass" 
            val MAP_KEY_VALUE_PROPERTY = "mapKeyValueProperty" 
            val KEY_PROPERTY_FRIENDLY_NAME = "keyPropertyFriendlyName" 
            val VALUE_CLASS = "valueClass" 
            val DELETE_ENTITY_UPON_REMOVE = "deleteEntityUponRemove" 
            val VALUE_PROPERTY_FRIENDLY_NAME = "valuePropertyFriendlyName" 
            val IS_SIMPLE_VALUE = "isSimpleValue" 
            val TO_ONE_TARGET_PROPERTY = "toOneTargetProperty" 
            val TO_ONE_PARENT_PROPERTY = "toOneParentProperty" 
            val MEDIA_FIELD = "mediaField" 
            val FORCE_FREE_FORM_KEYS = "forceFreeFormKeys" 
            val MAP_KEY_OPTION_ENTITY_CLASS = "mapKeyOptionEntityClass" 
            val MAP_KEY_OPTION_ENTITY_DISPLAY_FIELD = "mapKeyOptionEntityDisplayField" 
            val MAP_KEY_OPTION_ENTITY_VALUE_FIELD = "mapKeyOptionEntityValueField" 
            val CUSTOM_CRITERIA = "customCriteria" 
            val READ_ONLY = "readOnly" 
            val TAB = "tab" 
            val GROUP = "group" 
            val KEYS = "keys" 
            val ORDER = "order" 
        }

        object AdminPresentationMapField {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMapField"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationMapField")
            val MANY_TO_FIELD = "manyToField" 
            val FIELD_PRESENTATION = "fieldPresentation" 
            val TARGET_CLASS = "targetClass" 
            val FIELD_NAME = "fieldName" 
        }

        object AdminPresentationMapFields {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMapFields"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationMapFields")
            val TO_ONE_TARGET_PROPERTY = "toOneTargetProperty" 
            val TO_ONE_PARENT_PROPERTY = "toOneParentProperty" 
            val MAP_DISPLAY_FIELDS = "mapDisplayFields" 
        }

        object AdminPresentationMapKey {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMapKey"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationMapKey")
            val KEY_NAME = "keyName" 
            val FRIENDLY_KEY_NAME = "friendlyKeyName" 
        }

        object AdminPresentationOperationTypes {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes")
            val INSPECT_TYPE = "inspectType" 
            val REMOVE_TYPE = "removeType" 
            val UPDATE_TYPE = "updateType" 
            val FETCH_TYPE = "fetchType" 
            val ADD_TYPE = "addType" 
        }

        object AdminPresentationToOneLookup {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup")
            val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
            val LOOKUP_DISPLAY_PROPERTY = "lookupDisplayProperty" 
            val FORCE_POPULATE_CHILD_PROPERTIES = "forcePopulateChildProperties" 
            val ENABLE_TYPEAHEAD_LOOKUP = "enableTypeaheadLookup" 
            val CUSTOM_CRITERIA = "customCriteria" 
            val LOOKUP_TYPE = "lookupType" 
        }

        object AdminTabPresentation {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminTabPresentation"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminTabPresentation")
            val NAME = "name" 
            val GROUPS = "groups" 
            val ORDER = "order" 
        }

        object ConfigurationItem {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.ConfigurationItem"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.ConfigurationItem")
            val ITEM_NAME = "itemName" 
            val ITEM_VALUE = "itemValue" 
        }

        object FieldValueConfiguration {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.FieldValueConfiguration"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.FieldValueConfiguration")
            val FIELD_VALUES = "fieldValues" 
            val FIELD_NAME = "fieldName" 
        }

        object OptionFilterParam {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.OptionFilterParam"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.OptionFilterParam")
            val PARAM_TYPE = "paramType" 
            val PARAM = "param" 
            val VALUE = "value" 
        }

        object ValidationConfiguration {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.ValidationConfiguration"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.ValidationConfiguration")
            val VALIDATION_IMPLEMENTATION = "validationImplementation" 
            val CONFIGURATION_ITEMS = "configurationItems" 
        }

        object AdminGroupPresentationOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminGroupPresentationOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminGroupPresentationOverride")
            val GROUP_NAME = "groupName" 
            val TAB_NAME = "tabName" 
            val PROPERTY = "property" 
            val VALUE = "value" 
        }

        object AdminPresentationAdornedTargetCollectionOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationAdornedTargetCollectionOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationAdornedTargetCollectionOverride")
            val NAME = "name" 
            val VALUE = "value" 
        }

        object AdminPresentationCollectionOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationCollectionOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationCollectionOverride")
            val NAME = "name" 
            val VALUE = "value" 
        }

        object AdminPresentationDataDrivenEnumerationOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationDataDrivenEnumerationOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationDataDrivenEnumerationOverride")
            val NAME = "name" 
            val VALUE = "value" 
        }

        object AdminPresentationMapOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationMapOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationMapOverride")
            val NAME = "name" 
            val VALUE = "value" 
        }

        object AdminPresentationMergeEntry {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry")
            val PROPERTY_TYPE = "propertyType" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val VALIDATION_CONFIGURATIONS = "validationConfigurations" 
            val OPERATION_TYPES = "operationTypes" 
            val OPTION_FILTER_PARAMS = "optionFilterParams" 
            val OVERRIDE_VALUE = "overrideValue" 
            val DOUBLE_OVERRIDE_VALUE = "doubleOverrideValue" 
            val FLOAT_OVERRIDE_VALUE = "floatOverrideValue" 
            val BOOLEAN_OVERRIDE_VALUE = "booleanOverrideValue" 
            val INT_OVERRIDE_VALUE = "intOverrideValue" 
            val LONG_OVERRIDE_VALUE = "longOverrideValue" 
            val STRING_ARRAY_OVERRIDE_VALUE = "stringArrayOverrideValue" 
            val DOUBLE_ARRAY_OVERRIDE_VALUE = "doubleArrayOverrideValue" 
            val FLOAT_ARRAY_OVERRIDE_VALUE = "floatArrayOverrideValue" 
            val BOOLEAN_ARRAY_OVERRIDE_VALUE = "booleanArrayOverrideValue" 
            val INT_ARRAY_OVERRIDE_VALUE = "intArrayOverrideValue" 
            val LONG_ARRAY_OVERRIDE_VALUE = "longArrayOverrideValue" 
            val KEYS = "keys" 
        }

        object AdminPresentationMergeOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride")
            val MERGE_ENTRIES = "mergeEntries" 
            val NAME = "name" 
        }

        object AdminPresentationMergeOverrides {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverrides"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverrides")
            val VALUE = "value" 
        }

        object AdminPresentationOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationOverride")
            val NAME = "name" 
            val VALUE = "value" 
        }

        object AdminPresentationOverrides {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationOverrides"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationOverrides")
            val COLLECTIONS = "collections" 
            val MAPS = "maps" 
            val TO_ONE_LOOKUPS = "toOneLookups" 
            val ADORNED_TARGET_COLLECTIONS = "adornedTargetCollections" 
            val DATA_DRIVEN_ENUMS = "dataDrivenEnums" 
            val VALUE = "value" 
        }

        object AdminPresentationToOneLookupOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationToOneLookupOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminPresentationToOneLookupOverride")
            val NAME = "name" 
            val VALUE = "value" 
        }

        object AdminTabPresentationOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminTabPresentationOverride"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.override.AdminTabPresentationOverride")
            val TAB_NAME = "tabName" 
            val PROPERTY = "property" 
            val VALUE = "value" 
        }

    }

    object JpaAnnotations {
        object Id {
            val CLASS_NAME = "javax.persistence.Id"
        }

        object OneToMany {
            val CLASS_NAME = "javax.persistence.OneToMany"
            val FETCH = "fetch" 
            val TARGET_ENTITY = "targetEntity" 
            val CASCADE = "cascade" 
            val MAPPED_BY = "mappedBy" 
            val ORPHAN_REMOVAL = "orphanRemoval" 
        }

        object OneToOne {
            val CLASS_NAME = "javax.persistence.OneToOne"
            val FETCH = "fetch" 
            val TARGET_ENTITY = "targetEntity" 
            val CASCADE = "cascade" 
            val MAPPED_BY = "mappedBy" 
            val ORPHAN_REMOVAL = "orphanRemoval" 
            val OPTIONAL = "optional" 
        }

        object ManyToOne {
            val CLASS_NAME = "javax.persistence.ManyToOne"
            val FETCH = "fetch" 
            val TARGET_ENTITY = "targetEntity" 
            val CASCADE = "cascade" 
            val OPTIONAL = "optional" 
        }

        object ManyToMany {
            val CLASS_NAME = "javax.persistence.ManyToMany"
            val FETCH = "fetch" 
            val TARGET_ENTITY = "targetEntity" 
            val CASCADE = "cascade" 
            val MAPPED_BY = "mappedBy" 
        }

        object Entity {
            val CLASS_NAME = "javax.persistence.Entity"
            val NAME = "name" 
        }

        object Transient {
            val CLASS_NAME = "javax.persistence.Transient"
        }

        object MappedSuperclass {
            val CLASS_NAME = "javax.persistence.MappedSuperclass"
        }

        object Embeddable {
            val CLASS_NAME = "javax.persistence.Embeddable"
        }

        object Lob {
            val CLASS_NAME = "javax.persistence.Lob"
        }

        object Type {
            val CLASS_NAME = "org.hibernate.annotations.Type"
            val TYPE = "type" 
            val PARAMETERS = "parameters" 
        }

    }

    object EnumTypes {
        object OptionFilterParamType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.OptionFilterParamType"
            val BOOLEAN = "BOOLEAN" 
            val STRING = "STRING" 
            val INTEGER = "INTEGER" 
            val LONG = "LONG" 
            val DOUBLE = "DOUBLE" 
            val FLOAT = "FLOAT" 
            val BIGDECIMAL = "BIGDECIMAL" 
        }

        object PopulateToOneFieldsEnum {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.PopulateToOneFieldsEnum"
            val TRUE = "TRUE" 
            val FALSE = "FALSE" 
            val NOT_SPECIFIED = "NOT_SPECIFIED" 
        }

        object RequiredOverride {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.RequiredOverride"
            val REQUIRED = "REQUIRED" 
            val NOT_REQUIRED = "NOT_REQUIRED" 
            val IGNORED = "IGNORED" 
        }

        object AddMethodType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.AddMethodType"
            val PERSIST = "PERSIST" 
            val PERSIST_EMPTY = "PERSIST_EMPTY" 
            val LOOKUP = "LOOKUP" 
            val SELECTIZE_LOOKUP = "SELECTIZE_LOOKUP" 
            val LOOKUP_FOR_UPDATE = "LOOKUP_FOR_UPDATE" 
        }

        object AdornedTargetAddMethodType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.AdornedTargetAddMethodType"
            val LOOKUP = "LOOKUP" 
            val SELECTIZE_LOOKUP = "SELECTIZE_LOOKUP" 
        }

        object ForeignKeyRestrictionType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.ForeignKeyRestrictionType"
            val ID_EQ = "ID_EQ" 
            val COLLECTION_SIZE_EQ = "COLLECTION_SIZE_EQ" 
        }

        object LookupType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.LookupType"
            val STANDARD = "STANDARD" 
            val DROPDOWN = "DROPDOWN" 
        }

        object OperationType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.OperationType"
            val NONDESTRUCTIVEREMOVE = "NONDESTRUCTIVEREMOVE" 
            val BASIC = "BASIC" 
            val ADORNEDTARGETLIST = "ADORNEDTARGETLIST" 
            val MAP = "MAP" 
        }

        object PersistencePerspectiveItemType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType"
            val FOREIGNKEY = "FOREIGNKEY" 
            val ADORNEDTARGETLIST = "ADORNEDTARGETLIST" 
            val MAPSTRUCTURE = "MAPSTRUCTURE" 
        }

        object RuleBuilderDisplayType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.RuleBuilderDisplayType"
            val NORMAL = "NORMAL" 
            val RADIO = "RADIO" 
            val MODAL = "MODAL" 
        }

        object SupportedCriteriaFieldType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.SupportedCriteriaFieldType"
            val RULE = "RULE" 
            val RULE_MAP = "RULE_MAP" 
        }

        object SupportedFieldType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.SupportedFieldType"
            val UNKNOWN = "UNKNOWN" 
            val ID = "ID" 
            val BOOLEAN = "BOOLEAN" 
            val BOOLEAN_LINK = "BOOLEAN_LINK" 
            val DATE = "DATE" 
            val INTEGER = "INTEGER" 
            val DECIMAL = "DECIMAL" 
            val STRING = "STRING" 
            val COLLECTION = "COLLECTION" 
            val PASSWORD = "PASSWORD" 
            val PASSWORD_CONFIRM = "PASSWORD_CONFIRM" 
            val EMAIL = "EMAIL" 
            val FOREIGN_KEY = "FOREIGN_KEY" 
            val ADDITIONAL_FOREIGN_KEY = "ADDITIONAL_FOREIGN_KEY" 
            val MONEY = "MONEY" 
            val BROADLEAF_ENUMERATION = "BROADLEAF_ENUMERATION" 
            val EXPLICIT_ENUMERATION = "EXPLICIT_ENUMERATION" 
            val EMPTY_ENUMERATION = "EMPTY_ENUMERATION" 
            val DATA_DRIVEN_ENUMERATION = "DATA_DRIVEN_ENUMERATION" 
            val HTML = "HTML" 
            val HTML_BASIC = "HTML_BASIC" 
            val UPLOAD = "UPLOAD" 
            val HIDDEN = "HIDDEN" 
            val ASSET_URL = "ASSET_URL" 
            val ASSET_LOOKUP = "ASSET_LOOKUP" 
            val MEDIA = "MEDIA" 
            val RULE_SIMPLE = "RULE_SIMPLE" 
            val RULE_SIMPLE_TIME = "RULE_SIMPLE_TIME" 
            val RULE_WITH_QUANTITY = "RULE_WITH_QUANTITY" 
            val STRING_LIST = "STRING_LIST" 
            val IMAGE = "IMAGE" 
            val COLOR = "COLOR" 
            val CODE = "CODE" 
            val GENERATED_URL = "GENERATED_URL" 
            val GENERATED_FIELD_VALUE = "GENERATED_FIELD_VALUE" 
            val DESCRIPTION = "DESCRIPTION" 
        }

        object UnspecifiedBooleanType {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.UnspecifiedBooleanType"
            val TRUE = "TRUE" 
            val FALSE = "FALSE" 
            val UNSPECIFIED = "UNSPECIFIED" 
        }

        object VisibilityEnum {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.client.VisibilityEnum"
            val HIDDEN_ALL = "HIDDEN_ALL" 
            val VISIBLE_ALL = "VISIBLE_ALL" 
            val FORM_HIDDEN = "FORM_HIDDEN" 
            val GRID_HIDDEN = "GRID_HIDDEN" 
            val NOT_SPECIFIED = "NOT_SPECIFIED" 
            val FORM_EXPLICITLY_SHOWN = "FORM_EXPLICITLY_SHOWN" 
            val FORM_EXPLICITLY_HIDDEN = "FORM_EXPLICITLY_HIDDEN" 
        }

    }

    object FrameworkTypes {
        val BROADLEAF_ENUMERATION_TYPE = "org.broadleafcommerce.common.BroadleafEnumerationType" 
        val EXTENSION_RESULT_STATUS_TYPE = "org.broadleafcommerce.common.extension.ExtensionResultStatusType" 
        val EXTENSION_HANDLER = "org.broadleafcommerce.common.extension.ExtensionHandler" 
        val EXTENSION_MANAGER = "org.broadleafcommerce.common.extension.ExtensionManager" 
        val BROADLEAF_APPLICATION_LISTENER = "org.broadleafcommerce.common.event.BroadleafApplicationListener" 
        val CUSTOM_PERSISTENCE_HANDLER = "org.broadleafcommerce.openadmin.server.service.handler.CustomPersistenceHandler" 
        val CUSTOM_PERSISTENCE_HANDLER_ADAPTER = "org.broadleafcommerce.openadmin.server.service.handler.CustomPersistenceHandlerAdapter" 
        val CURRENT_ORDER_PAYMENT_REQUEST_SERVICE = "org.broadleafcommerce.common.payment.service.CurrentOrderPaymentRequestService" 
        val CUSTOMER_PAYMENT_GATEWAY_SERVICE = "org.broadleafcommerce.common.payment.service.CustomerPaymentGatewayService" 
        val FAILURE_COUNT_EXPOSABLE = "org.broadleafcommerce.common.payment.service.FailureCountExposable" 
        val PAYMENT_GATEWAY_CHECKOUT_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayCheckoutService" 
        val PAYMENT_GATEWAY_CLIENT_TOKEN_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayClientTokenService" 
        val PAYMENT_GATEWAY_CONFIGURATION = "org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration" 
        val PAYMENT_GATEWAY_CONFIGURATION_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationService" 
        val PAYMENT_GATEWAY_CREDIT_CARD_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayCreditCardService" 
        val PAYMENT_GATEWAY_CUSTOMER_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayCustomerService" 
        val PAYMENT_GATEWAY_FRAUD_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayFraudService" 
        val FIELD_METADATA = "org.broadleafcommerce.openadmin.dto.FieldMetadata" 
        val PAYMENT_GATEWAY_HOSTED_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayHostedService" 
        val PAYMENT_GATEWAY_REPORTING_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayReportingService" 
        val PAYMENT_GATEWAY_RESOLVER = "org.broadleafcommerce.common.payment.service.PaymentGatewayResolver" 
        val PAYMENT_GATEWAY_ROLLBACK_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayRollbackService" 
        val PAYMENT_GATEWAY_SUBSCRIPTION_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewaySubscriptionService" 
        val PAYMENT_GATEWAY_TAMPER_PROOF_SEAL_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayTamperProofSealService" 
        val PAYMENT_GATEWAY_TRANSACTION_CONFIRMATION_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionConfirmationService" 
        val PAYMENT_GATEWAY_TRANSACTION_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionService" 
        val PAYMENT_GATEWAY_TRANSPARENT_REDIRECT_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayTransparentRedirectService" 
        val PAYMENT_GATEWAY_WEB_RESPONSE_PRINT_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponsePrintService" 
        val PAYMENT_GATEWAY_WEB_RESPONSE_SERVICE = "org.broadleafcommerce.common.payment.service.PaymentGatewayWebResponseService" 
        val ABSTRACT_VENDOR_SERVICE = "org.broadleafcommerce.common.vendor.service.AbstractVendorService" 
        val SERVICE_STATUS_DETECTABLE = "org.broadleafcommerce.common.vendor.service.monitor.ServiceStatusDetectable" 
        val STATUS_HANDLER = "org.broadleafcommerce.common.vendor.service.monitor.StatusHandler" 
        val BROADLEAF_VARIABLE_EXPRESSION = "org.broadleafcommerce.common.web.expression.BroadleafVariableExpression" 
        val BROADLEAF_PROCESSOR = "org.broadleafcommerce.presentation.dialect.BroadleafProcessor" 
        val ADMIN_BASIC_ENTITY_CONTROLLER = "org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicEntityController" 
        val THREAD_LOCAL_MANAGER = "org.broadleafcommerce.common.classloader.release.ThreadLocalManager" 
        val ACTIVITY = "org.broadleafcommerce.core.workflow.Activity" 
        val PROCESSOR = "org.broadleafcommerce.core.workflow.Processor" 
        val DYNAMIC_ENTITY_DAO = "org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao" 
        val RECORD_HELPER = "org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper" 
        val CRITERIA_TRANSFER_OBJECT = "org.broadleafcommerce.openadmin.dto.CriteriaTransferObject" 
        val INSPECT_HELPER = "org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper" 
        val PROCESS_CONTEXT = "org.broadleafcommerce.core.workflow.ProcessContext" 
        val PERSISTENCE_PACKAGE = "org.broadleafcommerce.openadmin.dto.PersistencePackage" 
        val PROCESS_CONTEXT_FACTORY = "org.broadleafcommerce.core.workflow.ProcessContextFactory" 
        val ADMIN_MAIN_ENTITY = "org.broadleafcommerce.common.admin.domain.AdminMainEntity" 
        val MONEY = "org.broadleafcommerce.common.money.Money" 
        val FIELD_PERSISTENCE_PROVIDER = "org.broadleafcommerce.openadmin.server.service.persistence.module.provider.FieldPersistenceProvider" 
        val PERSISTENCE_MODULE = "org.broadleafcommerce.openadmin.server.service.persistence.module.PersistenceModule" 
    }

    object ThymeleafContextVariables {
        val MODEL = hashMapOf<String, String>()
        val EXPRESSIONS = hashMapOf<String, String>()
        val FIELD_TEMPLATES = hashSetOf<String>()
        init {
            MODEL.put("templateName", "java.lang.String")
            MODEL.put("listGrid", "org.broadleafcommerce.openadmin.web.form.component.ListGrid")
            MODEL.put("inModal", "java.lang.Boolean")
            MODEL.put("entityForm", "org.broadleafcommerce.openadmin.web.form.entity.EntityForm")
            MODEL.put("showSingleTab", "java.lang.Boolean")
            EXPRESSIONS.put("#cms", "org.broadleafcommerce.common.web.expression.AssetURLVariableExpression")
            EXPRESSIONS.put("#brc", "org.broadleafcommerce.common.web.expression.BRCVariableExpression")
            EXPRESSIONS.put("#breadcrumbs", "org.broadleafcommerce.common.web.expression.BreadcrumbVariableExpression")
            EXPRESSIONS.put("#enumeration", "org.broadleafcommerce.common.web.expression.DataDrivenEnumVariableExpression")
            EXPRESSIONS.put("#module", "org.broadleafcommerce.common.web.expression.ModuleVariableExpression")
            EXPRESSIONS.put("#props", "org.broadleafcommerce.common.web.expression.PropertiesVariableExpression")
            FIELD_TEMPLATES.add("unknown.html")
            FIELD_TEMPLATES.add("id.html")
            FIELD_TEMPLATES.add("boolean.html")
            FIELD_TEMPLATES.add("boolean_link.html")
            FIELD_TEMPLATES.add("date.html")
            FIELD_TEMPLATES.add("integer.html")
            FIELD_TEMPLATES.add("decimal.html")
            FIELD_TEMPLATES.add("string.html")
            FIELD_TEMPLATES.add("collection.html")
            FIELD_TEMPLATES.add("password.html")
            FIELD_TEMPLATES.add("password_confirm.html")
            FIELD_TEMPLATES.add("email.html")
            FIELD_TEMPLATES.add("foreign_key.html")
            FIELD_TEMPLATES.add("additional_foreign_key.html")
            FIELD_TEMPLATES.add("money.html")
            FIELD_TEMPLATES.add("broadleaf_enumeration.html")
            FIELD_TEMPLATES.add("explicit_enumeration.html")
            FIELD_TEMPLATES.add("empty_enumeration.html")
            FIELD_TEMPLATES.add("data_driven_enumeration.html")
            FIELD_TEMPLATES.add("html.html")
            FIELD_TEMPLATES.add("html_basic.html")
            FIELD_TEMPLATES.add("upload.html")
            FIELD_TEMPLATES.add("hidden.html")
            FIELD_TEMPLATES.add("asset_url.html")
            FIELD_TEMPLATES.add("asset_lookup.html")
            FIELD_TEMPLATES.add("media.html")
            FIELD_TEMPLATES.add("rule_simple.html")
            FIELD_TEMPLATES.add("rule_simple_time.html")
            FIELD_TEMPLATES.add("rule_with_quantity.html")
            FIELD_TEMPLATES.add("string_list.html")
            FIELD_TEMPLATES.add("image.html")
            FIELD_TEMPLATES.add("color.html")
            FIELD_TEMPLATES.add("code.html")
            FIELD_TEMPLATES.add("generated_url.html")
            FIELD_TEMPLATES.add("generated_field_value.html")
            FIELD_TEMPLATES.add("description.html")
        }    }

    object AcceptableTypes {
        val MAP_OR_COLLECTION = setOf("java.util.Collection", "java.util.Map") 
        val COLLECTION = "java.util.Collection" 
        val COLLECTION_TYPE = setOf("java.util.List", "java.util.Set") 
        val MAP = "java.util.Map" 
        val STRING = "java.lang.String" 
        val INTEGER = setOf("int", "java.lang.Integer", "long", "java.lang.Long") 
        val DECIMAL = setOf("double", "java.lang.Double", "java.lang.Float", "float", "java.math.BigDecimal") 
        val MONEY = "java.math.BigDecimal" 
        val SERIALIZABLE = "java.io.Serializable" 
        val THREAD_LOCAL = "java.lang.ThreadLocal" 
        val RELATION = setOf("javax.persistence.OneToOne", "javax.persistence.OneToMany", "javax.persistence.ManyToOne", "javax.persistence.ManyToMany") 
        val MANAGED_TYPES = setOf("javax.persistence.Entity", "javax.persistence.MappedSuperclass", "javax.persistence.Embeddable") 
        val BOOLEAN = setOf("boolean", "java.lang.Boolean") 
        val DATE = "java.util.Date" 
        val SIMPLE = setOf("java.lang.String", "int", "java.lang.Integer", "long", "java.lang.Long", "double", "java.lang.Double", "java.lang.Float", "float", "java.math.BigDecimal", "boolean", "java.lang.Boolean", "char", "java.lang.Character", "java.util.Date", "java.time.LocalDate", "java.time.LocalDateTime") 
    }

}