package com.pss.broadleaf.plugin.annotations

import com.intellij.openapi.util.Key
import com.intellij.psi.*

abstract class AnnotationWrapper(val annotation: PsiAnnotation) {

    val evaluater: PsiConstantEvaluationHelper = JavaPsiFacade.getInstance(annotation.project).constantEvaluationHelper

    abstract fun getMethods(): Map<String,  OverrideType>

    protected fun resolveDeclaredString(name: String): Pair<PsiElement, String>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractString(value)
    }

    protected fun resolveString(name: String): Pair<PsiElement, String>? {
        val value = annotation.findAttributeValue(name)
        return extractString(value)
    }

    protected fun resolveDeclaredStringArray(name: String): List<Pair<PsiElement, String>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractStringArray(value)
    }

    protected fun resolveStringArray(name: String): List<Pair<PsiElement, String>> {
        val value = annotation.findAttributeValue(name)
        return extractStringArray(value)
    }

    protected fun resolveDeclaredAnnotation(name: String): PsiAnnotation? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractAnnotation(value)
    }

    protected fun resolveAnnotation(name: String): PsiAnnotation? {
        val value = annotation.findAttributeValue(name)
        return extractAnnotation(value)
    }

    protected fun resolveDeclaredAnnotationArray(name: String): List<PsiAnnotation> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractAnnotationArray(value)
    }

    protected fun resolveAnnotationArray(name: String): List<PsiAnnotation> {
        val value = annotation.findAttributeValue(name)
        return extractAnnotationArray(value)
    }



    protected fun resolveDeclaredInt(name: String): Pair<PsiElement, Int>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractInt(value)
    }

    protected fun resolveInt(name: String): Pair<PsiElement, Int>? {
        val value = annotation.findAttributeValue(name)
        return extractInt(value)
    }

    protected fun resolveDeclaredIntArray(name: String): List<Pair<PsiElement, Int>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractIntArray(value)
    }

    protected fun resolveIntArray(name: String): List<Pair<PsiElement, Int>> {
        val value = annotation.findAttributeValue(name)
        return extractIntArray(value)
    }


    protected fun resolveDeclaredDouble(name: String): Pair<PsiElement, Double>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractDouble(value)
    }

    protected fun resolveDouble(name: String): Pair<PsiElement, Double>? {
        val value = annotation.findAttributeValue(name)
        return extractDouble(value)
    }

    protected fun resolveDeclaredDoubleArray(name: String): List<Pair<PsiElement, Double>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractDoubleArray(value)
    }

    protected fun resolveDoubleArray(name: String): List<Pair<PsiElement, Double>> {
        val value = annotation.findAttributeValue(name)
        return extractDoubleArray(value)
    }

    protected fun resolveDeclaredLong(name: String): Pair<PsiElement, Long>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractLong(value)
    }

    protected fun resolveLong(name: String): Pair<PsiElement, Long>? {
        val value = annotation.findAttributeValue(name)
        return extractLong(value)
    }
    protected fun resolveDeclaredLongArray(name: String): List<Pair<PsiElement, Long>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractLongArray(value)
    }

    protected fun resolveLongArray(name: String): List<Pair<PsiElement, Long>> {
        val value = annotation.findAttributeValue(name)
        return extractLongArray(value)
    }

    protected fun resolveBoolean(name: String): Pair<PsiElement, Boolean>? {
        val value = annotation.findAttributeValue(name)
        return extractBoolean(value)
    }
    protected fun resolveDeclaredBoolean(name: String): Pair<PsiElement, Boolean>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractBoolean(value)
    }
    protected fun resolveBooleanArray(name: String): List<Pair<PsiElement, Boolean>> {
        val value = annotation.findAttributeValue(name)
        return extractBooleanArray(value)
    }
    protected fun resolveDeclaredBooleanArray(name: String): List<Pair<PsiElement, Boolean>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractBooleanArray(value)
    }

    protected fun resolveDeclaredClass(name: String): Pair<PsiElement, PsiClass>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractClass(value)
    }

    protected fun resolveClass(name: String): Pair<PsiElement, PsiClass>? {
        val value = annotation.findAttributeValue(name)
        return extractClass(value)
    }
    protected fun resolveDeclaredClassArray(name: String): List<Pair<PsiElement, PsiClass>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractClassArray(value)
    }

    protected fun resolveClassArray(name: String): List<Pair<PsiElement, PsiClass>> {
        val value = annotation.findAttributeValue(name)
        return extractClassArray(value)
    }
    protected fun resolveDeclaredEnum(name: String): Pair<PsiElement, PsiField>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractEnum(value)
    }

    protected fun resolveEnum(name: String): Pair<PsiElement, PsiField>? {
        val value = annotation.findAttributeValue(name)
        return extractEnum(value)
    }
    protected fun resolveDeclaredEnumArray(name: String): List<Pair<PsiElement, PsiField>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractEnumArray(value)
    }

    protected fun resolveEnumArray(name: String): List<Pair<PsiElement, PsiField>> {
        val value = annotation.findAttributeValue(name)
        return extractEnumArray(value)
    }


    protected fun resolveDeclaredFloat(name: String): Pair<PsiElement, Float>? {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractFloat(value)
    }

    protected fun resolveFloat(name: String): Pair<PsiElement, Float>? {
        val value = annotation.findAttributeValue(name)
        return extractFloat(value)
    }

    protected fun resolveDeclaredFloatArray(name: String): List<Pair<PsiElement, Float>> {
        val value = annotation.findDeclaredAttributeValue(name)
        return extractFloatArray(value)
    }

    protected fun resolveFloatArray(name: String): List<Pair<PsiElement, Float>> {
        val value = annotation.findAttributeValue(name)
        return extractFloatArray(value)
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
    private fun extractClass(value: PsiAnnotationMemberValue?): Pair<PsiElement, PsiClass>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is PsiClass) {
                return Pair(value, resolved)
            }
        }
        return null
    }

    private fun extractClassArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, PsiClass>> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractClass(it) }
            } else {
                val extracted = extractClass(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
    }
    private fun extractInt(value: PsiAnnotationMemberValue?): Pair<PsiElement, Int>? {
        if (value != null) {
            val resolved = evaluater.computeConstantExpression(value)
            if (resolved is Int) {
                return Pair(value, resolved)
            }
        }
        return null
    }
    private fun extractIntArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, Int>> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractInt(it) }
            } else {
                val extracted = extractInt(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
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
    private fun extractDoubleArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, Double>> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractDouble(it) }
            } else {
                val extracted = extractDouble(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
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

    private fun extractFloatArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, Float>> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractFloat(it) }
            } else {
                val extracted = extractFloat(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
    }
    private fun extractAnnotation(value: PsiAnnotationMemberValue?): PsiAnnotation? {
        if (value != null && value is PsiAnnotation) {
            return value
        }
        return null
    }


    private fun extractAnnotationArray(value: PsiAnnotationMemberValue?): List<PsiAnnotation> {
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
    private fun extractLongArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, Long>> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractLong(it) }
            } else {
                val extracted = extractLong(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
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

    private fun extractBooleanArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, Boolean>> {
        if (value != null) {
            if(value is PsiArrayInitializerMemberValue){
                return value.initializers.mapNotNull { extractBoolean(it) }
            } else {
                val extracted = extractBoolean(value)
                if(extracted != null){
                    return listOf(extracted)
                }
            }
        }
        return emptyList()
    }
    private fun extractEnum(value: PsiAnnotationMemberValue?): Pair<PsiElement, PsiField>? {
        if (value != null && value is PsiReferenceExpression) {
            val resolved = value.resolve()
            if (resolved is PsiField) {
                return Pair(value, resolved)
            }
        }
        return null
    }

    private fun extractEnumArray(value: PsiAnnotationMemberValue?): List<Pair<PsiElement, PsiField>> {
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