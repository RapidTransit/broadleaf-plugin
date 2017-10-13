package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.*
import com.pss.broadleaf.plugin.BroadleafConstants
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationMap.CLASS_NAME_SET
import com.pss.broadleaf.plugin.isArray
import com.pss.broadleaf.plugin.isCollectionType
import com.pss.broadleaf.plugin.isManaged
import com.siyeh.ig.psiutils.CollectionUtils

class AdminPresentationMapInspection : PresentationAnnotationInspection(presentationAnnotation = CLASS_NAME_SET){

    override fun inspect(psiClass: PsiClass, psiField: PsiField, annotation: PsiAnnotation, holder: ProblemsHolder) {
        val isCollection = psiField.isCollectionType()

        val type = psiField.type
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
        } else {
            registerProblem(holder, psiField.typeElement?: psiField, "admin.map.type")
        }


    }

}