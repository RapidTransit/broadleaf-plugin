package com.pss.broadleaf.plugin.reference

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.openapi.diagnostic.Logger
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PsiJavaPatterns
import com.intellij.psi.*
import com.intellij.psi.search.searches.ClassInheritorsSearch

import com.intellij.util.ProcessingContext
import com.pss.broadleaf.plugin.doWithAnnotation
import com.pss.broadleaf.plugin.getField
import com.pss.broadleaf.plugin.getFields
import com.pss.broadleaf.plugin.isSimpleType
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection as Adorned

class AdornedReferenceContributor : PsiReferenceContributor() {

    companion object {
        val LOG : Logger  = Logger.getInstance(AdornedReferenceContributor::class.java);
        val TARGET_OBJECT_PROPERTY: ElementPattern<out PsiElement> = PsiJavaPatterns.psiLiteral()
                .annotationParam(Adorned.CLASS_NAME, Adorned.TARGET_OBJECT_PROPERTY)
        val GRID_VISIBLE_FIELDS: ElementPattern<out PsiElement> = PsiJavaPatterns.psiLiteral()
                .annotationParam(Adorned.CLASS_NAME, Adorned.GRID_VISIBLE_FIELDS)
        val MAINTAINED_ADORNED_TARGET_FIELDS: ElementPattern<out PsiElement> = PsiJavaPatterns.psiLiteral()
                .annotationParam(Adorned.CLASS_NAME, Adorned.MAINTAINED_ADORNED_TARGET_FIELDS)
    }

    enum class FieldRestriction {
        NONE, SIMPLE_TYPES_ONLY, ENTITY_TYPES_ONLY
    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(TARGET_OBJECT_PROPERTY, TargetObjectPropertyReferenceProvider())
        registrar.registerReferenceProvider(MAINTAINED_ADORNED_TARGET_FIELDS, MaintainedAdornedTargetFieldsReferenceProvider())
        registrar.registerReferenceProvider(GRID_VISIBLE_FIELDS, GridVisibleFieldsReferenceProvider())
    }

    class GridVisibleFieldsReferenceProvider : BaseFieldReferenceProvider(){
        override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            val type = field.type
            val list = mutableListOf<References>()
            if(type is PsiClassType && type.hasParameters()){
                val parameter = type.parameters.first()
                if(parameter is PsiClassType){

                     parameter.resolve()?.let {
                         findConcrete(it).forEach{ list.add(References(it, element as PsiLiteralExpression)) }
                    }

                    field.doWithAnnotation(Adorned.CLASS_NAME_SET, {psiField, psiAnnotation ->
                        AnnotationUtil.findDeclaredAttribute(psiAnnotation, Adorned.TARGET_OBJECT_PROPERTY)?.let {
                            it.literalValue?.let {
                                parameter.getFields(it).forEach {
                                    val type = it.type
                                    if(type is PsiClassType) {
                                        type.resolve()?.let{
                                            findConcrete(it).forEach { list.add(References(it, element as PsiLiteralExpression)) }
                                        }

                                    }
                                }
                            }
                        }
                    })
                }
            }


            return list.toTypedArray()
        }
    }

    class MaintainedAdornedTargetFieldsReferenceProvider : BaseFieldReferenceProvider(){
        override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {

               val type = field.type

                // Adorned fields can only be a collection type
               if(type is PsiClassType && type.hasParameters()){
                   val parameter = type.parameters.first()
                   if(parameter is PsiClassType){
                       return parameter.resolve()?.let {
                            return findConcrete(it).map { References(it, element as PsiLiteralExpression) }.toTypedArray()
                       }?: PsiReference.EMPTY_ARRAY
                   }
               }

            return PsiReference.EMPTY_ARRAY
        }

    }


    class TargetObjectPropertyReferenceProvider : BaseFieldReferenceProvider(){
        override fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                val type = field.type
                if(type is PsiClassType && type.hasParameters()){
                    val parameter = type.parameters.first()
                    if(parameter is PsiClassType){
                        val paramaterClass = parameter.resolve()
                        if(paramaterClass != null){
                            return findConcrete(paramaterClass).map { References(it, element as PsiLiteralExpression) }.toTypedArray()
                        }
                    }
                }
            return PsiReference.EMPTY_ARRAY
        }
    }

    abstract class BaseFieldReferenceProvider : PsiReferenceProvider() {

        override final fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
            val field = element.getField()
            if(field == null){
                return PsiReference.EMPTY_ARRAY
            } else {
                return getReferencesByElement(field, element, context)
            }
        }

        protected fun findConcrete(clazz: PsiClass): List<PsiClass> {
            return ClassInheritorsSearch.search(clazz).findAll().filter { !it.isInterface }
        }

        abstract protected fun getReferencesByElement(field: PsiField, element: PsiElement, context: ProcessingContext): Array<PsiReference>

    }

    class References(val context: PsiClass, myElement:  PsiLiteralExpression, val restriction: FieldRestriction = FieldRestriction.NONE, val exclude: Array<String> = emptyArray<String>()) : PsiReferenceBase<PsiLiteralExpression>(myElement, false) {
        override fun resolve(): PsiElement? {
            if(element.value is String) {
                return context.findFieldByName(element.value as String, true)
            }
            return null;
        }

        override fun bindToElement(element: PsiElement): PsiElement {
            if(element is PsiField){
                return handleElementRename(element.name)
            }
            return super.bindToElement(element)
        }

        override fun getVariants(): Array<Any> {
            return context.fields.map {it.name}.toTypedArray() as Array<Any>
        }
    }
}