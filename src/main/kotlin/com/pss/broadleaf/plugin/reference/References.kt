package com.pss.broadleaf.plugin.reference

import com.intellij.psi.*

class References(val context: PsiClass, myElement: PsiLiteralExpression, val restriction: AdornedReferenceContributor.FieldRestriction = AdornedReferenceContributor.FieldRestriction.NONE, val exclude: Array<String> = emptyArray<String>()) : PsiReferenceBase<PsiLiteralExpression>(myElement, false) {
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