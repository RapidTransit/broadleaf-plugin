package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.*

open class AnnotationWrapper(val annotation: PsiAnnotation) {

    val evaluater: PsiConstantEvaluationHelper = JavaPsiFacade.getInstance(annotation.project).constantEvaluationHelper


    protected fun resolveDeclaredStringArray(name: String): List<Pair<PsiElement, String>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractStringArray(value)
    }

    protected fun resolveStringArray(name: String): List<Pair<PsiElement, String>> {
        val value = annotation.findAttributeValue(name)
        return extractStringArray(value)
    }

    protected fun resolveDeclaredAnnotationArray(name: String): List<PsiAnnotation> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractAnnotationArrray(value)
    }

    protected fun resolveAnnotationArray(name: String): List<PsiAnnotation> {
        val value = annotation.findAttributeValue(name)
        return extractAnnotationArrray(value)
    }

    protected fun resolveDeclaredString(name: String): Pair<PsiElement, String>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractString(value)
    }

    protected fun resolveString(name: String): Pair<PsiElement, String>? {
        val value = annotation.findAttributeValue(name)
        return extractString(value)
    }

    protected fun resolveDeclaredInteger(name: String): Pair<PsiElement, Int>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractInteger(value)
    }

    protected fun resolveInteger(name: String): Pair<PsiElement, Int>? {
        val value = annotation.findAttributeValue(name)
        return extractInteger(value)
    }

    protected fun resolveDeclaredDouble(name: String): Pair<PsiElement, Double>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractDouble(value)
    }

    protected fun resolveDouble(name: String): Pair<PsiElement, Double>? {
        val value = annotation.findAttributeValue(name)
        return extractDouble(value)
    }

    protected fun resolveDeclaredLong(name: String): Pair<PsiElement, Long>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractLong(value)
    }

    protected fun resolveLong(name: String): Pair<PsiElement, Long>? {
        val value = annotation.findAttributeValue(name)
        return extractLong(value)
    }
    protected fun resolveBoolean(name: String): Pair<PsiElement, Boolean>? {
        val value = annotation.findAttributeValue(name)
        return extractBoolean(value)
    }
    protected fun resolveDeclaredBoolean(name: String): Pair<PsiElement, Boolean>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractBoolean(value)
    }


    protected fun resolveDeclaredClass(name: String): Pair<PsiElement, Int>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractInteger(value)
    }

    protected fun resolveClass(name: String): Pair<PsiElement, Int>? {
        val value = annotation.findAttributeValue(name)
        return extractInteger(value)
    }

    protected fun resolveDeclaredEnum(name: String): Pair<PsiElement, String>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractString(value)
    }

    protected fun resolveEnum(name: String): Pair<PsiElement, String>? {
        val value = annotation.findAttributeValue(name)
        return extractString(value)
    }


    protected fun resolveDeclaredAnnotation(name: String): PsiAnnotation? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractAnnotation(value)
    }

    protected fun resolveAnnotation(name: String): PsiAnnotation? {
        val value = annotation.findAttributeValue(name)
        return extractAnnotation(value)
    }


    protected fun resolveDeclaredFloat(name: String): Pair<PsiElement, Float>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractFloat(value)
    }

    protected fun resolveFloat(name: String): Pair<PsiElement, Float>? {
        val value = annotation.findAttributeValue(name)
        return extractFloat(value)
    }








    private fun extractString(value: PsiAnnotationMemberValue?): Pair<PsiElement, String>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is String) {
                return Pair(value, resolved)
            }
        }
        return null
    }

    private fun extractStringArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, String>> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractString(it) }
            } else {
                val extracted = extractString(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
    }

    private fun extractInteger(value: PsiAnnotationMemberValue?): Pair<PsiElement, Int>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is Int) {
                return Pair(value, resolved)
            }
        }
        return null
    }



    private fun extractDouble(value: PsiAnnotationMemberValue?): Pair<PsiElement, Double>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is Double) {
                return Pair(value, resolved)
            }
        }
        return null
    }

    private fun extractFloat(value: PsiAnnotationMemberValue?): Pair<PsiElement, Float>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is Float) {
                return Pair(value, resolved)
            }
        }
        return null
    }

    private fun extractAnnotation(value: PsiAnnotationMemberValue?): PsiAnnotation? {
        if (value != null && value is PsiAnnotation) {
            return value
        }
        return null
    }


    private fun extractAnnotationArrray(value: PsiAnnotationMemberValue?): List<PsiAnnotation> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractAnnotation(it) }
            } else {
                val extracted = extractAnnotation(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
    }

    private fun extractLong(value: PsiAnnotationMemberValue?): Pair<PsiElement, Long>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is Long) {
                return Pair(value, resolved)
            }
        }
        return null
    }
    private fun extractBoolean(value: PsiAnnotationMemberValue?): Pair<PsiElement, Boolean>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is Boolean) {
                return Pair(value, resolved)
            }
        }
        return null
    }
    private fun extractEnum(value: PsiAnnotationMemberValue?): Pair<PsiElement, String>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is String) {
                return Pair(value, resolved)
            }
        }
        return null
    }

    private fun extractEnumArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, String>> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractEnum(it) }
            } else {
                val extracted = extractEnum(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
    }
}