package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class ValidationConfigurationWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.ValidationConfiguration"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.ValidationConfiguration")
        val CONFIGURATION_ITEMS = "configurationItems" 
        val VALIDATION_IMPLEMENTATION = "validationImplementation" 

        val CONFIGURATION_ITEMS_KEY = Key<List<PsiAnnotation>?>("@configurationItems")
        val VALIDATION_IMPLEMENTATION_KEY = Key<Pair<PsiElement, String>?>("@validationImplementation")
    }


    fun configurationItems(): List<ConfigurationItemWrapper> {
        val anno = annotation.cacheGet(CONFIGURATION_ITEMS_KEY, { resolveDeclaredAnnotationArray(CONFIGURATION_ITEMS) })
        if(anno != null){
            return anno.map{ ConfigurationItemWrapper(it) }
        }
        return emptyList<ConfigurationItemWrapper>()
    }
    
    fun _configurationItems(): List<ConfigurationItemWrapper> {
        val anno =  annotation.cacheGet(CONFIGURATION_ITEMS_KEY, { resolveAnnotationArray(CONFIGURATION_ITEMS) })
        if(anno != null){
            return anno.map{ ConfigurationItemWrapper(it) }
        }
        return emptyList<ConfigurationItemWrapper>()
    }

    fun validationImplementation(): Pair<PsiElement, String>? {
        return annotation.cacheGet(VALIDATION_IMPLEMENTATION_KEY, { resolveDeclaredString(VALIDATION_IMPLEMENTATION) })
    }
    
    fun _validationImplementation(): Pair<PsiElement, String>? {
        return annotation.cacheGet(VALIDATION_IMPLEMENTATION_KEY, { resolveString(VALIDATION_IMPLEMENTATION) })
    }

}