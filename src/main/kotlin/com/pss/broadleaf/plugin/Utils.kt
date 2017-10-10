package com.pss.broadleaf.plugin

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.psi.*
import com.intellij.psi.impl.PsiClassImplUtil
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.pss.broadleaf.plugin.completion.AdornedReferenceContributor
import com.siyeh.ig.PsiReplacementUtil
import com.siyeh.ig.psiutils.CollectionUtils
import com.intellij.psi.util.InheritanceUtil;
import org.jetbrains.annotations.NotNull

object Utils {
    fun isFieldAnnotated(listOwner: PsiModifierListOwner, annotationFQN: String ): Boolean {
        return AnnotationUtil.isAnnotated(listOwner, annotationFQN, false, true, true)
    }

    fun getField(element: PsiElement): PsiField? {
        if(element is PsiField){
            return element;
        }
        var parent: PsiElement? = element;
        while(parent != null) {
            parent = parent.parent
            if (parent is PsiField) {
                return parent
            }
        }
        return null
    }


}
fun PsiElement.getField(): PsiField? {
    if(this is PsiField){
        return this;
    }
    var parent = this;
    while(parent != null) {
        parent = parent?.parent
        if (parent is PsiField) {
            return parent
        }
    }
    return null
}

fun PsiField.isCollectionType(): Boolean {
    return CollectionUtils.isCollectionClassOrInterface(this.type)
}

fun PsiField.isMapType(): Boolean {
    return InheritanceUtil.isInheritor(this.type, CommonClassNames.JAVA_UTIL_MAP)
}



fun PsiField.getCollectionComponent(): PsiClass? {
    val type = this.type
    if(type is PsiClassType && type.hasParameters()){
        val parameter = type.parameters.first()
        if(parameter is PsiClassType){
            return parameter.resolve()
        }
    }
    return null
}

fun PsiClass.getAllFieldsOfType(): List<PsiField> {
    if(this.isInterface){
        return ClassInheritorsSearch.search(this).findAll().filter { !it.isInterface }
                .flatMap { it.allFields.asList()}
    } else {
        return this.allFields.asList()
    }
}