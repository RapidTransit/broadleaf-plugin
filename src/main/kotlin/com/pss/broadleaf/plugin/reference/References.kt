package com.pss.broadleaf.plugin.reference

import com.intellij.psi.*

class References(
        val context: PsiClass,
        myElement: PsiLiteralExpression,
        val last: String,
        val split: MutableList<String> = mutableListOf(),
        val restriction: AdornedReferenceContributor.FieldRestriction = AdornedReferenceContributor.FieldRestriction.NONE,
        val exclude: Array<String> = emptyArray<String>()) : PsiReferenceBase<PsiLiteralExpression>(myElement, false) {

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