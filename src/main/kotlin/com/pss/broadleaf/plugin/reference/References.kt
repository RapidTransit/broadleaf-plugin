package com.pss.broadleaf.plugin.reference

import com.intellij.psi.*
import java.util.function.Predicate

class References(
        val context: PsiClass,
        val myElement: PsiLiteralExpression,
        val last: String,
        val split: MutableList<String> = mutableListOf()) : PsiReferenceBase<PsiLiteralExpression>(myElement, false) {

    override fun resolve(): PsiElement? {
        return context.findFieldByName(last, true)
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        if(element is PsiField){
            return handleElementRename(element.name)
        }
        return super.bindToElement(element)
    }

    override fun getVariants(): Array<Any> {
        if(split.isNotEmpty()) {
            val joined = split.joinToString(".", postfix = ".")
            return context.fields.map { joined + it.name }.toTypedArray() as Array<Any>
        } else {
            return context.fields.map { it.name }.toTypedArray() as Array<Any>
        }
    }
}

class SimplePathReference (
        myElement: PsiLiteralExpression,
        private val psiClass: PsiClass,
        private val property: String,
        private val predicate: (PsiField) -> Boolean = { _ -> true }) : PsiReferenceBase<PsiLiteralExpression>(myElement, false) {

    override fun resolve(): PsiElement? {
        return psiClass.findFieldByName(property, true)
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        if(element is PsiField){
            return handleElementRename(element.name)
        }
        return super.bindToElement(element)
    }

    override fun getVariants(): Array<Any> {
        return psiClass.fields.filter{ this.predicate(it) }.map { it.name }.filterNotNull().toTypedArray<Any>()
    }
}

class PropertyPathReference (
        myElement: PsiLiteralExpression,
        private val psiClass: PsiClass,
        private val initialPathSegments: List<String>,
        private val lastPathSegment: String,
        private val predicate: (PsiField) -> Boolean = { _ -> true }) : PsiReferenceBase<PsiLiteralExpression>(myElement, false) {

    override fun resolve(): PsiElement? {
        return psiClass.findFieldByName(lastPathSegment, true)
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        if(element is PsiField){
            return handleElementRename(element.name)
        }
        return super.bindToElement(element)
    }


    override fun getVariants(): Array<Any> {
        val joined = initialPathSegments.joinToString(".", postfix = ".")
        return psiClass.fields.filter { this.predicate(it) }.map { joined + it.name }.toTypedArray<Any>()
    }
}