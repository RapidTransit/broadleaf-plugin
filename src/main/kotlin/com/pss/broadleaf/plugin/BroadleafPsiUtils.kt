package com.pss.broadleaf.plugin

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.*
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.psi.util.PsiTypesUtil
import com.siyeh.ig.psiutils.CollectionUtils
import org.funktionale.pipe.pipe10

object BroadleafPsiUtils {


    //Todo: Try to make this work with inspections and Reference Providers
    fun navigatePath(
            literalExpression: PsiLiteralExpression,
            func: (propertyPath: String, segmentPrefix: List<String>, lastSegment: String, psiField: PsiField, type: PsiClass, concrete: List<PsiClass>) -> Unit) {

        val propertyPath = literalExpression.value as String?
        val pathSegments = if (propertyPath == null)  mutableListOf<String>() else StringUtil.split(propertyPath, ".")
        val psiField = literalExpression.getField()
        if(pathSegments.isNotEmpty() && psiField != null && propertyPath != null){
            psiField.getClassTypeOrComponentClassType()?.let {
                val segmentPrefix: List<String>
                val lastSegment: String
                if(pathSegments.size == 1){
                    segmentPrefix = emptyList()
                    lastSegment = pathSegments.first()
                } else {
                    segmentPrefix = pathSegments.dropLast(1)
                    lastSegment = pathSegments.last()
                }
                if(it is PsiClassType){
                    it.resolve()?.let {
                        val findConcrete = findConcrete(it)
                        func(propertyPath, segmentPrefix, lastSegment, psiField, it, findConcrete)
                    }
                }
            }
        }
    }



    fun findConcrete(clazz: PsiClass): List<PsiClass> {
        ClassInheritorsSearch.search(clazz).findAll().filter { !it.isInterface }.let{
            if(!clazz.isInterface){
                return it.plus(clazz)
            }
            return it
        }
    }

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

