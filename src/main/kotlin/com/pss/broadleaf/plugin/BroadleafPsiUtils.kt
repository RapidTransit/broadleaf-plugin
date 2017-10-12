package com.pss.broadleaf.plugin

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.psi.*
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.psi.util.PsiTypesUtil

object BroadleafPsiUtils {


    fun parentOfType(element: PsiElement): PsiField? {
        if(element is PsiField){
            return element;
        } else {
            var parent = element.parent
            while(parent != null){
                if(parent is PsiField){
                    return parent
                } else {
                    parent = parent.parent
                }
            }
        }
        return null
    }


    fun isFieldAnnotated(listOwner: PsiModifierListOwner, annotationFQN: String ): Boolean {
        return AnnotationUtil.isAnnotated(listOwner, annotationFQN, false, true)
    }

    fun getField(element: PsiElement): PsiField? {
        if(element is PsiField){
            return element
        }
        var parent: PsiElement? = element;
        while(parent != null) {
            parent = parent.parent
            if (parent is PsiField) {
                return parent
            }
        }
        return null
    }

    fun containsAnnotation(type: PsiType, fqn: Set<String>): Boolean {
        val clazz = PsiTypesUtil.getPsiClass(type)
        if(clazz != null){
            if(clazz.isInterface){
                return ClassInheritorsSearch.search(clazz, true ).findAll()
                        .any { !it.isInterface && it.isAnnotated(fqn) }
            } else {
                return clazz.isAnnotated(fqn)
            }
        }
        return false
    }

    fun containsAnnotation(type: PsiType, fqn: String): Boolean {
        val clazz = PsiTypesUtil.getPsiClass(type)
        if(clazz != null){
            return containsAnnotation(clazz, fqn)
        }
        return false
    }

    fun containsAnnotation(clazz: PsiClass, fqn: String): Boolean {

        if(clazz.isInterface){
            return ClassInheritorsSearch.search(clazz, true ).findAll()
                    .any { !it.isInterface && it.isAnnotated(fqn) }
        } else {
            return clazz.isAnnotated(fqn)
        }
    }

}

