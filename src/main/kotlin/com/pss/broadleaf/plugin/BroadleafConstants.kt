package com.pss.broadleaf.plugin

import java.util.*

object BroadleafConstants {

    object PresentationAnnotations {
        object AdminGroupPresentation {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminGroupPresentation"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminGroupPresentation")
            val COLLAPSED = "collapsed" 
            val UNTITLED = "untitled" 
            val TOOLTIP = "tooltip" 
            val COLUMN = "column" 
            val NAME = "name" 
            val ORDER = "order" 
        }

        object AdminPresentation {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentation"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentation")
            val HINT = "hint" 
            val CAN_LINK_TO_EXTERNAL_ENTITY = "canLinkToExternalEntity" 
            val HIDE_ENUMERATION_IF_EMPTY = "hideEnumerationIfEmpty" 
            val FRIENDLY_NAME = "friendlyName" 
            val BROADLEAF_ENUMERATION = "broadleafEnumeration" 
            val ALLOW_NO_VALUE_ENUM_OPTION = "allowNoValueEnumOption" 
            val FIELD_COMPONENT_RENDERER = "fieldComponentRenderer" 
            val ADD_FRIENDLY_NAME = "addFriendlyName" 
            val TOOLTIP = "tooltip" 
            val SECURITY_LEVEL = "securityLevel" 
            val GRID_ORDER = "gridOrder" 
            val DISPLAY_TYPE = "displayType" 
            val GROUP_ORDER = "groupOrder" 
            val GROUP_COLLAPSED = "groupCollapsed" 
            val TAB_ORDER = "tabOrder" 
            val LARGE_ENTRY = "largeEntry" 
            val PROMINENT = "prominent" 
            val COLUMN_WIDTH = "columnWidth" 
            val VALIDATION_CONFIGURATIONS = "validationConfigurations" 
            val REQUIRED_OVERRIDE = "requiredOverride" 
            val HELP_TEXT = "helpText" 
            val SHOW_IF_PROPERTY = "showIfProperty" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val CURRENCY_CODE_FIELD = "currencyCodeField" 
            val RULE_IDENTIFIER = "ruleIdentifier" 
            val TRANSLATABLE = "translatable" 
            val ASSOCIATED_FIELD_NAME = "associatedFieldName" 
            val VISIBILITY = "visibility" 
            val EXCLUDED = "excluded" 
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
            val FRIENDLY_NAME = "friendlyName" 
            val LAZY_FETCH = "lazyFetch" 
            val MANUAL_FETCH = "manualFetch" 
            val SELECTIZE_VISIBLE_FIELD = "selectizeVisibleField" 
            val SECURITY_LEVEL = "securityLevel" 
            val TAB_ORDER = "tabOrder" 
            val SHOW_IF_PROPERTY = "showIfProperty" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val CURRENCY_CODE_FIELD = "currencyCodeField" 
            val JOIN_ENTITY_CLASS = "joinEntityClass" 
            val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
            val PARENT_OBJECT_PROPERTY = "parentObjectProperty" 
            val PARENT_OBJECT_ID_PROPERTY = "parentObjectIdProperty" 
            val TARGET_OBJECT_PROPERTY = "targetObjectProperty" 
            val MAINTAINED_ADORNED_TARGET_FIELDS = "maintainedAdornedTargetFields" 
            val GRID_VISIBLE_FIELDS = "gridVisibleFields" 
            val TARGET_OBJECT_ID_PROPERTY = "targetObjectIdProperty" 
            val SORT_PROPERTY = "sortProperty" 
            val SORT_ASCENDING = "sortAscending" 
            val IGNORE_ADORNED_PROPERTIES = "ignoreAdornedProperties" 
            val CUSTOM_CRITERIA = "customCriteria" 
            val OPERATION_TYPES = "operationTypes" 
            val EXCLUDED = "excluded" 
            val READ_ONLY = "readOnly" 
            val TAB = "tab" 
            val ADD_TYPE = "addType" 
            val GROUP = "group" 
            val ORDER = "order" 
        }

        object AdminPresentationClass {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationClass"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationClass")
            val FRIENDLY_NAME = "friendlyName" 
            val POPULATE_TO_ONE_FIELDS = "populateToOneFields" 
            val CEILING_DISPLAY_ENTITY = "ceilingDisplayEntity" 
            val EXCLUDE_FROM_POLYMORPHISM = "excludeFromPolymorphism" 
            val TABS = "tabs" 
            val TAB_OVERRIDES = "tabOverrides" 
            val GROUP_OVERRIDES = "groupOverrides" 
        }

        object AdminPresentationCollection {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationCollection"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationCollection")
            val FRIENDLY_NAME = "friendlyName" 
            val MANY_TO_FIELD = "manyToField" 
            val LAZY_FETCH = "lazyFetch" 
            val MANUAL_FETCH = "manualFetch" 
            val SELECTIZE_VISIBLE_FIELD = "selectizeVisibleField" 
            val ADD_FRIENDLY_NAME = "addFriendlyName" 
            val SECURITY_LEVEL = "securityLevel" 
            val TAB_ORDER = "tabOrder" 
            val SHOW_IF_PROPERTY = "showIfProperty" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val CURRENCY_CODE_FIELD = "currencyCodeField" 
            val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
            val SORT_PROPERTY = "sortProperty" 
            val SORT_ASCENDING = "sortAscending" 
            val CUSTOM_CRITERIA = "customCriteria" 
            val OPERATION_TYPES = "operationTypes" 
            val EXCLUDED = "excluded" 
            val READ_ONLY = "readOnly" 
            val TAB = "tab" 
            val ADD_TYPE = "addType" 
            val GROUP = "group" 
            val ORDER = "order" 
        }

        object AdminPresentationDataDrivenEnumeration {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration")
            val OPTION_FILTER_PARAMS = "optionFilterParams" 
            val OPTION_VALUE_FIELD_NAME = "optionValueFieldName" 
            val OPTION_DISPLAY_FIELD_NAME = "optionDisplayFieldName" 
            val OPTION_CAN_EDIT_VALUES = "optionCanEditValues" 
            val OPTION_HIDE_IF_EMPTY = "optionHideIfEmpty" 
            val OPTION_LIST_ENTITY = "optionListEntity" 
        }

        object AdminPresentationMap {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMap"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationMap")
            val FRIENDLY_NAME = "friendlyName" 
            val TO_ONE_TARGET_PROPERTY = "toOneTargetProperty" 
            val TO_ONE_PARENT_PROPERTY = "toOneParentProperty" 
            val MEDIA_FIELD = "mediaField" 
            val FORCE_FREE_FORM_KEYS = "forceFreeFormKeys" 
            val MAP_KEY_OPTION_ENTITY_CLASS = "mapKeyOptionEntityClass" 
            val MAP_KEY_OPTION_ENTITY_DISPLAY_FIELD = "mapKeyOptionEntityDisplayField" 
            val MAP_KEY_OPTION_ENTITY_VALUE_FIELD = "mapKeyOptionEntityValueField" 
            val MANY_TO_FIELD = "manyToField" 
            val LAZY_FETCH = "lazyFetch" 
            val MANUAL_FETCH = "manualFetch" 
            val KEY_CLASS = "keyClass" 
            val MAP_KEY_VALUE_PROPERTY = "mapKeyValueProperty" 
            val KEY_PROPERTY_FRIENDLY_NAME = "keyPropertyFriendlyName" 
            val VALUE_CLASS = "valueClass" 
            val DELETE_ENTITY_UPON_REMOVE = "deleteEntityUponRemove" 
            val VALUE_PROPERTY_FRIENDLY_NAME = "valuePropertyFriendlyName" 
            val IS_SIMPLE_VALUE = "isSimpleValue" 
            val ADD_FRIENDLY_NAME = "addFriendlyName" 
            val SECURITY_LEVEL = "securityLevel" 
            val TAB_ORDER = "tabOrder" 
            val SHOW_IF_PROPERTY = "showIfProperty" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val CURRENCY_CODE_FIELD = "currencyCodeField" 
            val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
            val CUSTOM_CRITERIA = "customCriteria" 
            val OPERATION_TYPES = "operationTypes" 
            val EXCLUDED = "excluded" 
            val READ_ONLY = "readOnly" 
            val TAB = "tab" 
            val GROUP = "group" 
            val KEYS = "keys" 
            val ORDER = "order" 
        }

        object AdminPresentationMapField {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationMapField"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationMapField")
            val FIELD_PRESENTATION = "fieldPresentation" 
            val MANY_TO_FIELD = "manyToField" 
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
            val FRIENDLY_KEY_NAME = "friendlyKeyName" 
            val KEY_NAME = "keyName" 
        }

        object AdminPresentationOperationTypes {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes")
            val FETCH_TYPE = "fetchType" 
            val REMOVE_TYPE = "removeType" 
            val UPDATE_TYPE = "updateType" 
            val INSPECT_TYPE = "inspectType" 
            val ADD_TYPE = "addType" 
        }

        object AdminPresentationToOneLookup {
            val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup"
            val CLASS_NAME_SET = Collections.singleton("org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup")
            val USE_SERVER_SIDE_INSPECTION_CACHE = "useServerSideInspectionCache" 
            val CUSTOM_CRITERIA = "customCriteria" 
            val LOOKUP_DISPLAY_PROPERTY = "lookupDisplayProperty" 
            val FORCE_POPULATE_CHILD_PROPERTIES = "forcePopulateChildProperties" 
            val ENABLE_TYPEAHEAD_LOOKUP = "enableTypeaheadLookup" 
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
            val TAB_NAME = "tabName" 
            val GROUP_NAME = "groupName" 
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
            val OPTION_FILTER_PARAMS = "optionFilterParams" 
            val VALIDATION_CONFIGURATIONS = "validationConfigurations" 
            val SHOW_IF_FIELD_EQUALS = "showIfFieldEquals" 
            val OPERATION_TYPES = "operationTypes" 
            val INT_ARRAY_OVERRIDE_VALUE = "intArrayOverrideValue" 
            val LONG_ARRAY_OVERRIDE_VALUE = "longArrayOverrideValue" 
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
            val PROPERTY_TYPE = "propertyType" 
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
            val DATA_DRIVEN_ENUMS = "dataDrivenEnums" 
            val TO_ONE_LOOKUPS = "toOneLookups" 
            val ADORNED_TARGET_COLLECTIONS = "adornedTargetCollections" 
            val COLLECTIONS = "collections" 
            val MAPS = "maps" 
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
            val CASCADE = "cascade" 
            val MAPPED_BY = "mappedBy" 
            val ORPHAN_REMOVAL = "orphanRemoval" 
            val FETCH = "fetch" 
            val TARGET_ENTITY = "targetEntity" 
        }

        object OneToOne {
            val CLASS_NAME = "javax.persistence.OneToOne"
            val CASCADE = "cascade" 
            val MAPPED_BY = "mappedBy" 
            val ORPHAN_REMOVAL = "orphanRemoval" 
            val FETCH = "fetch" 
            val TARGET_ENTITY = "targetEntity" 
            val OPTIONAL = "optional" 
        }

        object ManyToOne {
            val CLASS_NAME = "javax.persistence.ManyToOne"
            val CASCADE = "cascade" 
            val FETCH = "fetch" 
            val TARGET_ENTITY = "targetEntity" 
            val OPTIONAL = "optional" 
        }

        object ManyToMany {
            val CLASS_NAME = "javax.persistence.ManyToMany"
            val CASCADE = "cascade" 
            val MAPPED_BY = "mappedBy" 
            val FETCH = "fetch" 
            val TARGET_ENTITY = "targetEntity" 
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
        val THREAD_LOCAL_MANAGER = "org.broadleafcommerce.common.classloader.release.ThreadLocalManager" 
        val ADMIN_MAIN_ENTITY = "org.broadleafcommerce.common.admin.domain.AdminMainEntity" 
        val MONEY = "org.broadleafcommerce.common.money.Money" 
    }

    object AcceptableTypes {
        val MAP_OR_COLLECTION = setOf("java.util.Collection", "java.util.Map") 
        val COLLECTION = "java.util.Collection" 
        val MAP = "java.util.Map" 
        val STRING = "java.lang.String" 
        val INTEGER = setOf("int", "java.lang.Integer", "long", "java.lang.Long") 
        val DECIMAL = setOf("double", "java.lang.Double", "java.lang.Float", "float", "java.math.BigDecimal") 
        val MONEY = "java.math.BigDecimal" 
        val SERIALIZABLE = "java.io.Serializable" 
        val THREAD_LOCAL = "java.lang.ThreadLocal" 
        val MANAGED_TYPES = setOf("javax.persistence.Entity", "javax.persistence.MappedSuperclass", "javax.persistence.Embeddable") 
        val BOOLEAN = setOf("boolean", "java.lang.Boolean") 
        val DATE = "java.util.Date" 
        val SIMPLE = setOf("java.lang.String", "int", "java.lang.Integer", "long", "java.lang.Long", "double", "java.lang.Double", "java.lang.Float", "float", "java.math.BigDecimal", "boolean", "java.lang.Boolean", "char", "java.lang.Character", "java.util.Date", "java.time.LocalDate", "java.time.LocalDateTime") 
    }

}