package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class OptionFilterParamWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.OptionFilterParam"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.OptionFilterParam")
        val PARAM = "param" 
        val PARAM_TYPE = "paramType" 
        val VALUE = "value" 

        val INVOKERS = mapOf<String, (OptionFilterParamWrapper)->Any?>(Pair("param", {wrapper-> wrapper.param() }) , Pair("paramType", {wrapper-> wrapper.paramType() }) , Pair("value", {wrapper-> wrapper.value() }) )
        val METHODS = mapOf<String, OverrideType>(Pair("param", OverrideType.STRING), Pair("paramType", OverrideType.ENUM), Pair("value", OverrideType.STRING))
        val PARAM_KEY = Key<Pair<PsiElement, String>?>("@param")
        val PARAM_TYPE_KEY = Key<Pair<PsiElement, PsiField>?>("@paramType")
        val VALUE_KEY = Key<Pair<PsiElement, String>?>("@value")
    }


    override fun getMethods(): Map<String, OverrideType> {
        return METHODS
    }

    fun param(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PARAM_KEY, { resolveDeclaredString(PARAM) })
    }
    
    fun _param(): Pair<PsiElement, String>? {
        return annotation.cacheGet(PARAM_KEY, { resolveString(PARAM) })
    }

    fun paramType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(PARAM_TYPE_KEY, { resolveDeclaredEnum(PARAM_TYPE) })
    }
    
    fun _paramType(): Pair<PsiElement, PsiField>? {
        return annotation.cacheGet(PARAM_TYPE_KEY, { resolveEnum(PARAM_TYPE) })
    }

    fun value(): Pair<PsiElement, String>? {
        return annotation.cacheGet(VALUE_KEY, { resolveDeclaredString(VALUE) })
    }
    
    fun _value(): Pair<PsiElement, String>? {
        return annotation.cacheGet(VALUE_KEY, { resolveString(VALUE) })
    }

}