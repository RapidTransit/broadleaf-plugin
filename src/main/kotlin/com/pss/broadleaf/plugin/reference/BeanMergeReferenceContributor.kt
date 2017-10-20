package com.pss.broadleaf.plugin.reference

import com.intellij.openapi.components.service
import com.intellij.util.ProcessingContext
import com.intellij.patterns.PsiJavaPatterns.*
import com.intellij.psi.*
import com.intellij.psi.filters.ElementFilter
import com.intellij.psi.filters.position.FilterPattern
import com.intellij.psi.util.PsiClassUtil
import com.intellij.spring.model.SpringModelSearchParameters
import com.intellij.spring.model.utils.SpringModelUtils
import com.intellij.spring.model.utils.search.SpringBeanSearchParameters
import com.intellij.spring.model.utils.search.executors.XmlBeanClassQueryExecutor
import com.intellij.spring.references.SpringBeanReference
import com.intellij.spring.references.SpringBeanReferenceProvider
import com.pss.broadleaf.plugin.BroadleafConstants
import com.pss.broadleaf.plugin.findParent


class BeanMergeReferenceContributor : PsiReferenceContributor(){


    companion object {
        val MAP = psiElement().annotationParam("org.broadleafcommerce.common.extensibility.context.merge.Merge", "value").and(FilterPattern(MapFilter()))
        val LIST = psiElement().annotationParam("org.broadleafcommerce.common.extensibility.context.merge.Merge", "value").and(FilterPattern(ListFilter()))
    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {

        registrar.registerReferenceProvider(LIST, SpringBeanReferenceProvider({ element  ->
            return@SpringBeanReferenceProvider JavaPsiFacade.getInstance(element.project).findClass("org.springframework.beans.factory.config.ListFactoryBean", element.resolveScope)
        }), 100.0)
        registrar.registerReferenceProvider(LIST, SpringBeanReferenceProvider({ element  ->
            return@SpringBeanReferenceProvider JavaPsiFacade.getInstance(element.project).findClass(CommonClassNames.JAVA_UTIL_LIST, element.resolveScope)
        }), 100.0)

        registrar.registerReferenceProvider(MAP, SpringBeanReferenceProvider({ element  ->
            return@SpringBeanReferenceProvider JavaPsiFacade.getInstance(element.project).findClass("org.springframework.beans.factory.config.MapFactoryBean", element.resolveScope)
        }), 100.0)
        registrar.registerReferenceProvider(MAP, SpringBeanReferenceProvider({ element  ->
            return@SpringBeanReferenceProvider JavaPsiFacade.getInstance(element.project).findClass(CommonClassNames.JAVA_UTIL_MAP, element.resolveScope)
        }), 100.0)
    }

    class ListFilter : ElementFilter {
        override fun isAcceptable(element: Any?, context: PsiElement?): Boolean {
            context?.findParent(PsiMethod::class.java)?.let {
                val type = it.returnType
                if(type is PsiClassType){
                    return type.resolve()?.qualifiedName == CommonClassNames.JAVA_UTIL_LIST
                }
            }
            return false
        }

        override fun isClassAcceptable(hintClass: Class<*>?): Boolean {
            return true
        }
    }

    class MapFilter : ElementFilter {
        override fun isAcceptable(element: Any?, context: PsiElement?): Boolean {
            context?.findParent(PsiMethod::class.java)?.let {
                val type = it.returnType
                if(type is PsiClassType){
                    return type.resolve()?.qualifiedName == CommonClassNames.JAVA_UTIL_MAP
                }
            }
            return false
        }

        override fun isClassAcceptable(hintClass: Class<*>?): Boolean {
            return true
        }
    }
}