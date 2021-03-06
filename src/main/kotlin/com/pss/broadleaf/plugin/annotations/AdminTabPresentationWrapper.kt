package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminTabPresentationWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminTabPresentation"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminTabPresentation")
        val GROUPS = "groups" 
        val NAME = "name" 
        val ORDER = "order" 

        val INVOKERS = mapOf<String, (AdminTabPresentationWrapper)->Any?>(Pair("groups", {wrapper-> wrapper.groups() }) , Pair("name", {wrapper-> wrapper.name() }) , Pair("order", {wrapper-> wrapper.order() }) )
        val METHODS = mapOf<String, OverrideType>(Pair("groups)", OverrideType.ANNOTATION_ARRAY), Pair("name", OverrideType.STRING), Pair("order", OverrideType.INT))
        val GROUPS_KEY = Key<List<PsiAnnotation>?>("@groups")
        val NAME_KEY = Key<Pair<PsiElement, String>?>("@name")
        val ORDER_KEY = Key<Pair<PsiElement, Int>?>("@order")
    }


    override fun getMethods(): Map<String, OverrideType> {
        return METHODS
    }

    fun groups(): List<AdminGroupPresentationWrapper> {
        val anno = annotation.cacheGet(GROUPS_KEY, { resolveDeclaredAnnotationArray(GROUPS) })
        if(anno != null){
            return anno.map{ AdminGroupPresentationWrapper(it) }
        }
        return emptyList<AdminGroupPresentationWrapper>()
    }
    
    fun _groups(): List<AdminGroupPresentationWrapper> {
        val anno =  annotation.cacheGet(GROUPS_KEY, { resolveAnnotationArray(GROUPS) })
        if(anno != null){
            return anno.map{ AdminGroupPresentationWrapper(it) }
        }
        return emptyList<AdminGroupPresentationWrapper>()
    }

    fun name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveDeclaredString(NAME) })
    }
    
    fun _name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveString(NAME) })
    }

    fun order(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(ORDER_KEY, { resolveDeclaredInt(ORDER) })
    }
    
    fun _order(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(ORDER_KEY, { resolveInt(ORDER) })
    }

}