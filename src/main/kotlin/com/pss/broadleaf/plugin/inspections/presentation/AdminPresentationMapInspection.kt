package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.jam.model.util.JamCommonUtil
import com.intellij.psi.*
import com.intellij.refactoring.util.EnumConstantsUtil
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationMap.CLASS_NAME_SET
import com.pss.broadleaf.plugin.annotations.AdminPresentationMapWrapper
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationMap as PM
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationMapKey as MK
import com.pss.broadleaf.plugin.isArray
import com.pss.broadleaf.plugin.isCollectionType
import com.pss.broadleaf.plugin.isManaged
import com.siyeh.ig.psiutils.ExpressionUtils
import javax.lang.model.type.ArrayType

class AdminPresentationMapInspection : PresentationAnnotationInspection(presentationAnnotation = CLASS_NAME_SET){

    override fun inspect(psiClass: PsiClass, psiField: PsiField, annotation: PsiAnnotation, holder: ProblemsHolder) {
        val isCollection = psiField.isCollectionType()
        val type = psiField.type

        val an = AdminPresentationMapWrapper(annotation)
        val b = an.keyClass()
        if(type is PsiClassType && type.resolve()?.qualifiedName == "java.util.Map"){
            val parameterCount = type.parameterCount
            if(parameterCount == 2) {
                val firstParam = type.parameters[0]
                val secondParam = type.parameters[1]
                val typeParameters = psiField.typeElement?.innermostComponentReferenceElement?.parameterList?.typeParameterElements
                if (firstParam.isArray() || (firstParam is PsiClassType && firstParam.resolve()?.qualifiedName != "java.lang.String")) {
                    registerProblem(holder, typeParameters?.elementAt(0)?:psiField, "admin.map.key.string")
                }

                if (secondParam is PsiClassType && !secondParam.isManaged()) {
                    registerProblem(holder, typeParameters?.elementAt(1)?:psiField, "admin.map.value.managed")
                }
            }

            // Check to Make sure keys are present when the value forceFreeFormKeys == false (Default)
            annotation.findAttributeValue(PM.FORCE_FREE_FORM_KEYS)?.let { forceFreeFormKeys ->
                if(forceFreeFormKeys is PsiLiteralExpression){
                    ExpressionUtils.computeConstantExpression(forceFreeFormKeys)?.let {
                        if(it is Boolean){
                            if(!it){
                                val mapKeyValues = annotation.findDeclaredAttributeValue(PM.KEYS)
                                if(mapKeyValues == null){
                                    registerProblem(holder, annotation, "admin.map.must-assign-explicit-keys")
                                } else if (mapKeyValues is PsiArrayInitializerMemberValue) {
                                    if(mapKeyValues.initializers.isEmpty()){
                                        registerProblem(holder, mapKeyValues, "admin.map.empty-map-keys")
                                    } else {
                                        val presentKeys = mutableListOf<String>()
                                        mapKeyValues.initializers.forEach { intializer ->
                                            if(intializer is PsiAnnotation){
                                                processAdminPresentationMapKey(presentKeys, intializer, holder)
                                            }
                                        }
                                    }
                                } else if(mapKeyValues is PsiAnnotation){
                                    processAdminPresentationMapKey(mutableListOf(), mapKeyValues, holder)
                                }

                            }
                        }
                    }
                }
            }

        } else {
            registerProblem(holder, psiField.typeElement?: psiField, "admin.map.type")
        }


    }

    private fun processAdminPresentationMapKey(presentKeys: MutableList<String>, mapKeyAnnotation: PsiAnnotation, holder: ProblemsHolder){
        val memberValue = mapKeyAnnotation.findDeclaredAttributeValue(MK.KEY_NAME)
        if(memberValue != null){
            if(memberValue is PsiExpression){
                val value = ExpressionUtils.getLiteralString(memberValue)
                if(value == null){
                    return
                } else if(value.isEmpty()){
                    registerProblem(holder, memberValue, "admin.map.value-is-empty")
                } else if(presentKeys.contains(value)){
                    registerProblem(holder, memberValue, "admin.map.key-already-present")
                } else {
                    presentKeys.add(value)
                }
            }
        }
    }

}