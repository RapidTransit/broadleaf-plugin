
package com.pss.broadleaf.plugin.annotations

import com.intellij.psi.PsiAnnotation

object AnnotationFactory {

    val ENUM_TYPES = mapOf<String, Set<String>>(Pair("displayType", AdminPresentationWrapper.CLASS_NAME_SET), Pair("fieldComponentRenderer", AdminPresentationWrapper.CLASS_NAME_SET), Pair("fieldType", AdminPresentationWrapper.CLASS_NAME_SET), Pair("requiredOverride", AdminPresentationWrapper.CLASS_NAME_SET), Pair("visibility", AdminPresentationWrapper.CLASS_NAME_SET), Pair("addType", AdminPresentationAdornedTargetCollectionWrapper.CLASS_NAME_SET), Pair("populateToOneFields", AdminPresentationClassWrapper.CLASS_NAME_SET), Pair("addType", AdminPresentationCollectionWrapper.CLASS_NAME_SET), Pair("isSimpleValue", AdminPresentationMapWrapper.CLASS_NAME_SET), Pair("addType", AdminPresentationOperationTypesWrapper.CLASS_NAME_SET), Pair("fetchType", AdminPresentationOperationTypesWrapper.CLASS_NAME_SET), Pair("inspectType", AdminPresentationOperationTypesWrapper.CLASS_NAME_SET), Pair("removeType", AdminPresentationOperationTypesWrapper.CLASS_NAME_SET), Pair("updateType", AdminPresentationOperationTypesWrapper.CLASS_NAME_SET), Pair("lookupType", AdminPresentationToOneLookupWrapper.CLASS_NAME_SET), Pair("paramType", OptionFilterParamWrapper.CLASS_NAME_SET))
    val ENUM_ARRAY_TYPES = mapOf<String, Set<String>>()
    val ANNOTATION_TYPES = mapOf<String, Set<String>>(Pair("operationTypes", AdminPresentationAdornedTargetCollectionWrapper.CLASS_NAME_SET), Pair("operationTypes", AdminPresentationCollectionWrapper.CLASS_NAME_SET), Pair("operationTypes", AdminPresentationMapWrapper.CLASS_NAME_SET), Pair("fieldPresentation", AdminPresentationMapFieldWrapper.CLASS_NAME_SET), Pair("operationTypes", AdminPresentationMergeEntryWrapper.CLASS_NAME_SET))
    val ANNOTATION_ARRAY_TYPES = mapOf<String, Set<String>>(Pair("showIfFieldEquals", AdminPresentationWrapper.CLASS_NAME_SET), Pair("validationConfigurations", AdminPresentationWrapper.CLASS_NAME_SET), Pair("showIfFieldEquals", AdminPresentationAdornedTargetCollectionWrapper.CLASS_NAME_SET), Pair("groupOverrides", AdminPresentationClassWrapper.CLASS_NAME_SET), Pair("tabOverrides", AdminPresentationClassWrapper.CLASS_NAME_SET), Pair("tabs", AdminPresentationClassWrapper.CLASS_NAME_SET), Pair("showIfFieldEquals", AdminPresentationCollectionWrapper.CLASS_NAME_SET), Pair("optionFilterParams", AdminPresentationDataDrivenEnumerationWrapper.CLASS_NAME_SET), Pair("keys", AdminPresentationMapWrapper.CLASS_NAME_SET), Pair("showIfFieldEquals", AdminPresentationMapWrapper.CLASS_NAME_SET), Pair("mapDisplayFields", AdminPresentationMapFieldsWrapper.CLASS_NAME_SET), Pair("groups", AdminTabPresentationWrapper.CLASS_NAME_SET), Pair("configurationItems", ValidationConfigurationWrapper.CLASS_NAME_SET), Pair("keys", AdminPresentationMergeEntryWrapper.CLASS_NAME_SET), Pair("optionFilterParams", AdminPresentationMergeEntryWrapper.CLASS_NAME_SET), Pair("showIfFieldEquals", AdminPresentationMergeEntryWrapper.CLASS_NAME_SET), Pair("validationConfigurations", AdminPresentationMergeEntryWrapper.CLASS_NAME_SET))
    private val MAP_FACTORY: MutableMap<String, (PsiAnnotation)-> AnnotationWrapper> = mutableMapOf()

    init {
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminGroupPresentation", {annotation-> AdminGroupPresentationWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentation", {annotation-> AdminPresentationWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection", {annotation-> AdminPresentationAdornedTargetCollectionWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationClass", {annotation-> AdminPresentationClassWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationCollection", {annotation-> AdminPresentationCollectionWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationDataDrivenEnumeration", {annotation-> AdminPresentationDataDrivenEnumerationWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationMap", {annotation-> AdminPresentationMapWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationMapField", {annotation-> AdminPresentationMapFieldWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationMapFields", {annotation-> AdminPresentationMapFieldsWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationMapKey", {annotation-> AdminPresentationMapKeyWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationOperationTypes", {annotation-> AdminPresentationOperationTypesWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup", {annotation-> AdminPresentationToOneLookupWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.AdminTabPresentation", {annotation-> AdminTabPresentationWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.ConfigurationItem", {annotation-> ConfigurationItemWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.FieldValueConfiguration", {annotation-> FieldValueConfigurationWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.OptionFilterParam", {annotation-> OptionFilterParamWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.ValidationConfiguration", {annotation-> ValidationConfigurationWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminGroupPresentationOverride", {annotation-> AdminGroupPresentationOverrideWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationAdornedTargetCollectionOverride", {annotation-> AdminPresentationAdornedTargetCollectionOverrideWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationCollectionOverride", {annotation-> AdminPresentationCollectionOverrideWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationDataDrivenEnumerationOverride", {annotation-> AdminPresentationDataDrivenEnumerationOverrideWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationMapOverride", {annotation-> AdminPresentationMapOverrideWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry", {annotation-> AdminPresentationMergeEntryWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride", {annotation-> AdminPresentationMergeOverrideWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverrides", {annotation-> AdminPresentationMergeOverridesWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationOverride", {annotation-> AdminPresentationOverrideWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationOverrides", {annotation-> AdminPresentationOverridesWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminPresentationToOneLookupOverride", {annotation-> AdminPresentationToOneLookupOverrideWrapper(annotation)})
        MAP_FACTORY.put("org.broadleafcommerce.common.presentation.override.AdminTabPresentationOverride", {annotation-> AdminTabPresentationOverrideWrapper(annotation)})
    }

    fun getFactory(): Map<String, (PsiAnnotation)-> AnnotationWrapper> {
        return MAP_FACTORY
    }

}
