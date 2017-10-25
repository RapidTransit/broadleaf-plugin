package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationOverridesWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationOverrides"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.override.AdminPresentationOverrides")
        val ADORNED_TARGET_COLLECTIONS = "adornedTargetCollections" 
        val COLLECTIONS = "collections" 
        val DATA_DRIVEN_ENUMS = "dataDrivenEnums" 
        val MAPS = "maps" 
        val TO_ONE_LOOKUPS = "toOneLookups" 
        val VALUE = "value" 

        val INVOKERS = mapOf<String, (AdminPresentationOverridesWrapper)->Any?>(Pair("adornedTargetCollections", {wrapper-> wrapper.adornedTargetCollections() }) , Pair("collections", {wrapper-> wrapper.collections() }) , Pair("dataDrivenEnums", {wrapper-> wrapper.dataDrivenEnums() }) , Pair("maps", {wrapper-> wrapper.maps() }) , Pair("toOneLookups", {wrapper-> wrapper.toOneLookups() }) , Pair("value", {wrapper-> wrapper.value() }) )
        val METHODS = mapOf<String, OverrideType>(Pair("adornedTargetCollections)", OverrideType.ANNOTATION_ARRAY), Pair("collections)", OverrideType.ANNOTATION_ARRAY), Pair("dataDrivenEnums)", OverrideType.ANNOTATION_ARRAY), Pair("maps)", OverrideType.ANNOTATION_ARRAY), Pair("toOneLookups)", OverrideType.ANNOTATION_ARRAY), Pair("value)", OverrideType.ANNOTATION_ARRAY))
        val ADORNED_TARGET_COLLECTIONS_KEY = Key<List<PsiAnnotation>?>("@adornedTargetCollections")
        val COLLECTIONS_KEY = Key<List<PsiAnnotation>?>("@collections")
        val DATA_DRIVEN_ENUMS_KEY = Key<List<PsiAnnotation>?>("@dataDrivenEnums")
        val MAPS_KEY = Key<List<PsiAnnotation>?>("@maps")
        val TO_ONE_LOOKUPS_KEY = Key<List<PsiAnnotation>?>("@toOneLookups")
        val VALUE_KEY = Key<List<PsiAnnotation>?>("@value")
    }


    override fun getMethods(): Map<String, OverrideType> {
        return METHODS
    }

    fun adornedTargetCollections(): List<AdminPresentationAdornedTargetCollectionOverrideWrapper> {
        val anno = annotation.cacheGet(ADORNED_TARGET_COLLECTIONS_KEY, { resolveDeclaredAnnotationArray(ADORNED_TARGET_COLLECTIONS) })
        if(anno != null){
            return anno.map{ AdminPresentationAdornedTargetCollectionOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationAdornedTargetCollectionOverrideWrapper>()
    }
    
    fun _adornedTargetCollections(): List<AdminPresentationAdornedTargetCollectionOverrideWrapper> {
        val anno =  annotation.cacheGet(ADORNED_TARGET_COLLECTIONS_KEY, { resolveAnnotationArray(ADORNED_TARGET_COLLECTIONS) })
        if(anno != null){
            return anno.map{ AdminPresentationAdornedTargetCollectionOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationAdornedTargetCollectionOverrideWrapper>()
    }

    fun collections(): List<AdminPresentationCollectionOverrideWrapper> {
        val anno = annotation.cacheGet(COLLECTIONS_KEY, { resolveDeclaredAnnotationArray(COLLECTIONS) })
        if(anno != null){
            return anno.map{ AdminPresentationCollectionOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationCollectionOverrideWrapper>()
    }
    
    fun _collections(): List<AdminPresentationCollectionOverrideWrapper> {
        val anno =  annotation.cacheGet(COLLECTIONS_KEY, { resolveAnnotationArray(COLLECTIONS) })
        if(anno != null){
            return anno.map{ AdminPresentationCollectionOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationCollectionOverrideWrapper>()
    }

    fun dataDrivenEnums(): List<AdminPresentationDataDrivenEnumerationOverrideWrapper> {
        val anno = annotation.cacheGet(DATA_DRIVEN_ENUMS_KEY, { resolveDeclaredAnnotationArray(DATA_DRIVEN_ENUMS) })
        if(anno != null){
            return anno.map{ AdminPresentationDataDrivenEnumerationOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationDataDrivenEnumerationOverrideWrapper>()
    }
    
    fun _dataDrivenEnums(): List<AdminPresentationDataDrivenEnumerationOverrideWrapper> {
        val anno =  annotation.cacheGet(DATA_DRIVEN_ENUMS_KEY, { resolveAnnotationArray(DATA_DRIVEN_ENUMS) })
        if(anno != null){
            return anno.map{ AdminPresentationDataDrivenEnumerationOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationDataDrivenEnumerationOverrideWrapper>()
    }

    fun maps(): List<AdminPresentationMapOverrideWrapper> {
        val anno = annotation.cacheGet(MAPS_KEY, { resolveDeclaredAnnotationArray(MAPS) })
        if(anno != null){
            return anno.map{ AdminPresentationMapOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationMapOverrideWrapper>()
    }
    
    fun _maps(): List<AdminPresentationMapOverrideWrapper> {
        val anno =  annotation.cacheGet(MAPS_KEY, { resolveAnnotationArray(MAPS) })
        if(anno != null){
            return anno.map{ AdminPresentationMapOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationMapOverrideWrapper>()
    }

    fun toOneLookups(): List<AdminPresentationToOneLookupOverrideWrapper> {
        val anno = annotation.cacheGet(TO_ONE_LOOKUPS_KEY, { resolveDeclaredAnnotationArray(TO_ONE_LOOKUPS) })
        if(anno != null){
            return anno.map{ AdminPresentationToOneLookupOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationToOneLookupOverrideWrapper>()
    }
    
    fun _toOneLookups(): List<AdminPresentationToOneLookupOverrideWrapper> {
        val anno =  annotation.cacheGet(TO_ONE_LOOKUPS_KEY, { resolveAnnotationArray(TO_ONE_LOOKUPS) })
        if(anno != null){
            return anno.map{ AdminPresentationToOneLookupOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationToOneLookupOverrideWrapper>()
    }

    fun value(): List<AdminPresentationOverrideWrapper> {
        val anno = annotation.cacheGet(VALUE_KEY, { resolveDeclaredAnnotationArray(VALUE) })
        if(anno != null){
            return anno.map{ AdminPresentationOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationOverrideWrapper>()
    }
    
    fun _value(): List<AdminPresentationOverrideWrapper> {
        val anno =  annotation.cacheGet(VALUE_KEY, { resolveAnnotationArray(VALUE) })
        if(anno != null){
            return anno.map{ AdminPresentationOverrideWrapper(it) }
        }
        return emptyList<AdminPresentationOverrideWrapper>()
    }

}