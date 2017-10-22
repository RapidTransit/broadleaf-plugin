package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.PsiAnnotation
import com.pss.broadleaf.plugin.cacheGet
import com.intellij.psi.PsiElement

class AdminGroupPresentationWrapper(annotation: PsiAnnotation) : AnnotationWrapper(annotation) {

    companion object {
        val CLASS_NAME = "org.broadleafcommerce.common.presentation.AdminGroupPresentation"
        val CLASS_NAME_SET = setOf("org.broadleafcommerce.common.presentation.AdminGroupPresentation")
        val COLLAPSED = "collapsed" 
        val COLUMN = "column" 
        val NAME = "name" 
        val ORDER = "order" 
        val TOOLTIP = "tooltip" 
        val UNTITLED = "untitled" 

        val COLLAPSED_KEY = Key<Pair<PsiElement, Boolean>?>("@collapsed")
        val COLUMN_KEY = Key<Pair<PsiElement, Int>?>("@column")
        val NAME_KEY = Key<Pair<PsiElement, String>?>("@name")
        val ORDER_KEY = Key<Pair<PsiElement, Int>?>("@order")
        val TOOLTIP_KEY = Key<Pair<PsiElement, String>?>("@tooltip")
        val UNTITLED_KEY = Key<Pair<PsiElement, Boolean>?>("@untitled")
    }


    fun collapsed(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(COLLAPSED_KEY, { resolveDeclaredBoolean(COLLAPSED) })
    }
    
    fun _collapsed(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(COLLAPSED_KEY, { resolveBoolean(COLLAPSED) })
    }

    fun column(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(COLUMN_KEY, { resolveDeclaredInteger(COLUMN) })
    }
    
    fun _column(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(COLUMN_KEY, { resolveInteger(COLUMN) })
    }

    fun name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveDeclaredString(NAME) })
    }
    
    fun _name(): Pair<PsiElement, String>? {
        return annotation.cacheGet(NAME_KEY, { resolveString(NAME) })
    }

    fun order(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(ORDER_KEY, { resolveDeclaredInteger(ORDER) })
    }
    
    fun _order(): Pair<PsiElement, Int>? {
        return annotation.cacheGet(ORDER_KEY, { resolveInteger(ORDER) })
    }

    fun tooltip(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TOOLTIP_KEY, { resolveDeclaredString(TOOLTIP) })
    }
    
    fun _tooltip(): Pair<PsiElement, String>? {
        return annotation.cacheGet(TOOLTIP_KEY, { resolveString(TOOLTIP) })
    }

    fun untitled(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(UNTITLED_KEY, { resolveDeclaredBoolean(UNTITLED) })
    }
    
    fun _untitled(): Pair<PsiElement, Boolean>? {
        return annotation.cacheGet(UNTITLED_KEY, { resolveBoolean(UNTITLED) })
    }

}