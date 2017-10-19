package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.*
import com.intellij.util.containers.isNullOrEmpty
import com.pss.broadleaf.plugin.*
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection as Adorned
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection.CLASS_NAME_SET

class AdminPresentationAdornedInspection : PresentationAnnotationInspection(presentationAnnotation = CLASS_NAME_SET){

    override fun inspect(psiClass: PsiClass, psiField: PsiField, annotation: PsiAnnotation, holder: ProblemsHolder) {

        val isCollection = psiField.isCollectionType()

        if(!isCollection){
            registerProblem(holder, psiField.typeElement?:psiField, "admin.adorned.collection")
            return
        }

        psiField.getCollectionComponent()?.let {
            if(!it.isEntity()){
                registerProblem(holder, psiField.typeElement?.innermostComponentReferenceElement?.parameterList?.typeParameterElements?.get(0)?:psiField, "admin.adorned.not-managed")
                return@inspect
            }
        }

        val mappedByField = psiField.getMappedBy()

        annotation.findDeclaredAttributeValue(Adorned.TARGET_OBJECT_PROPERTY)?.let { memberValue ->
            if(memberValue is PsiLiteralExpression){
                val fields = psiField.getTargetEntity()?.getFields(memberValue.value as String)
                if(fields.isNullOrEmpty()){
                    registerProblem(holder, memberValue, "admin.adorned.target-object-property")
                } else {
                    if(!fields!!.any { !it.isSimpleType() && it.type.isEntity() }){
                        registerProblem(holder, memberValue, "admin.adorned.target-object-property.not-managed")
                    }
                }

            }
        }
        val adorned = psiField.getAdornedPsiClasses()
//        annotation.findDeclaredAttributeValue(Adorned.MAINTAINED_ADORNED_TARGET_FIELDS)?.let { memberValue ->
//            when(memberValue){
//                is PsiLiteralExpression -> handleLiteral(memberValue, psiField, adorned, holder)
//                is PsiReferenceExpression -> handleReference(memberValue, psiField, adorned, holder)
//                is PsiArrayInitializerMemberValue -> handleArray(memberValue, psiField, adorned, holder)
//            }
//        }

        annotation.findDeclaredAttributeValue(Adorned.GRID_VISIBLE_FIELDS)?.let { memberValue ->
            when(memberValue){
                is PsiLiteralExpression -> handleLiteral(memberValue, psiField, adorned, holder)
                is PsiReferenceExpression -> handleReference(memberValue, psiField, adorned, holder)
                is PsiArrayInitializerMemberValue -> handleArray(memberValue, psiField, adorned, holder)
            }
        }


    }

    fun handle(value: String, element: PsiElement, field: PsiField, adorned: List<PsiClass>, holder: ProblemsHolder){
        val split = StringUtil.split(value, ".")
        var copy = adorned
        for((idx, part) in split.withIndex()){
            copy = copy.reduceFields(part)
            if(copy.isEmpty()){
                registerProblem(holder, element, "admin.adorned.target-object-property.not-managed")
            }
            if(split.size == (idx + 1)){
                field.resolveScope
                if(copy.all { it.isEntity() }){
                    registerProblem(holder, element, "admin.adorned.target-object-property.not-managed")
                }
            }

        }
    }

    fun handleLiteral(literalValue: PsiLiteralExpression, field: PsiField, adorned: List<PsiClass>, holder: ProblemsHolder){
        val value = literalValue.value
        if(value is String){
            handle(value, literalValue, field, adorned, holder)
        }
    }

    fun handleReference(referenceExpression: PsiReferenceExpression, field: PsiField, adorned: List<PsiClass>, holder: ProblemsHolder){
        val value = JavaPsiFacade.getInstance(referenceExpression.project).getConstantEvaluationHelper().computeConstantExpression(referenceExpression)
        if(value is String){
            handle(value, referenceExpression, field, adorned, holder)
        }
    }

    fun handleArray(arrayInitializerMemberValue: PsiArrayInitializerMemberValue, field: PsiField, adorned: List<PsiClass>, holder: ProblemsHolder){
        arrayInitializerMemberValue.initializers.forEach { memberValue ->
            when(memberValue){
                is PsiLiteralExpression -> handleLiteral(memberValue, field, adorned, holder)
                is PsiReferenceExpression -> handleReference(memberValue, field, adorned, holder)
            }
        }
    }

}