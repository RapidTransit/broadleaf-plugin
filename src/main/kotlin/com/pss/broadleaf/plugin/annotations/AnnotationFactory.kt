
package com.pss.broadleaf.plugin.annotations

import com.intellij.psi.PsiAnnotation

object AnnotationFactory {

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
