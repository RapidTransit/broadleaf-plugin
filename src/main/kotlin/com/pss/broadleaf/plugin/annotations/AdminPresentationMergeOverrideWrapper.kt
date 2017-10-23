package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminPresentationMergeOverrideWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride")
        val MERGE_ENTRIES = "mergeEntries" 
        val NAME = "name" 

        val METHODS = mapOf<String, Class<out Any>>(Pair("mergeEntries)", Array<Annotation>::class.java), Pair("name", String::class.java))
        val MERGE_ENTRIES_KEY = Key<List<PsiAnnotation>?>("@mergeEntries")
        val NAME_KEY = Key<Pair<PsiElement, String>?>("@name")
    }


    override fun getMethods(): Map<String, Class<out Any>> {
        return METHODS
    }

    fun mergeEntries(): List<AdminPresentationMergeEntryWrapper> {
        val anno = annotation.cacheGet(MERGE_ENTRIES_KEY, { resolveDeclaredAnnotationArray(MERGE_ENTRIES) })
        if(anno != null){
            return anno.map{ AdminPresentationMergeEntryWrapper(it) }
        }
        return emptyList<AdminPresentationMergeEntryWrapper>()
    }
    
    fun _mergeEntries(): List<AdminPresentationMergeEntryWrapper> {
        val anno =  annotation.cacheGet(MERGE_ENTRIES_KEY, { resolveAnnotationArray(MERGE_ENTRIES) })
        if(anno != null){
            return anno.map{ AdminPresentationMergeEntryWrapper(it) }
        }
        return emptyList<AdminPresentationMergeEntryWrapper>()
    }

    fun name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveDeclaredString(NAME) })
    }
    
    fun _name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveString(NAME) })
    }

}