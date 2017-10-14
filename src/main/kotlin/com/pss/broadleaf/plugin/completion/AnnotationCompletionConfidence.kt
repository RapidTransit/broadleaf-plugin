package com.pss.broadleaf.plugin.completion

import com.intellij.codeInsight.completion.CompletionConfidence
import com.intellij.patterns.PsiJavaPatterns.*

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.util.ThreeState
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection as Adorned
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationToOneLookup as ToOne
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentation
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationMergeOverride as MergeOverride

class AnnotationCompletionConfidence : CompletionConfidence() {

    // @Todo: Benchmark this, but for now the most readable
    companion object {
        val MATCHER = or(
                literalExpression()
                        .insideAnnotationParam(string().matches(Adorned.CLASS_NAME), Adorned.TARGET_OBJECT_PROPERTY),
                literalExpression()
                        .insideAnnotationParam(string().matches(Adorned.CLASS_NAME), Adorned.GRID_VISIBLE_FIELDS),
                literalExpression()
                        .insideAnnotationParam(string().matches(Adorned.CLASS_NAME), Adorned.MAINTAINED_ADORNED_TARGET_FIELDS),
                literalExpression()
                        .insideAnnotationParam(string().matches(AdminPresentation.CLASS_NAME), AdminPresentation.BROADLEAF_ENUMERATION),
                literalExpression()
                        .insideAnnotationParam(string().matches(ToOne.CLASS_NAME), ToOne.LOOKUP_DISPLAY_PROPERTY),
                literalExpression()
                        .insideAnnotationParam(string().matches(MergeOverride.CLASS_NAME), MergeOverride.NAME)

        )
    }


    override fun shouldSkipAutopopup(contextElement: PsiElement, psiFile: PsiFile, offset: Int): ThreeState {

        val parent = contextElement.parent
        if(parent != null && MATCHER.accepts(parent)){
            return ThreeState.NO
        }
        return super.shouldSkipAutopopup(contextElement, psiFile, offset)
    }
}