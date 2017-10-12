package com.pss.broadleaf.plugin.completion

import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.java.JavaLanguage
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.PsiLiteralExpression
import com.pss.broadleaf.plugin.BroadleafPsiUtils

//Todo: To do auto complete I think there needs to be some sort of Lexer and Parser
class PropertyMultiHostInjector : MultiHostInjector {

    val elements = mutableListOf<Class<out PsiElement>>(PsiLiteralExpression::class.java)

    override fun elementsToInjectIn(): MutableList<out Class<out PsiElement>> {
        return elements
    }

    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        if(context == null){
            return;
        }
        if(BroadleafPsiUtils.getField(context) != null){
            registrar.startInjecting(JavaLanguage.INSTANCE)
                    .addPlace(null, null, context as PsiLanguageInjectionHost, TextRange.create(0, context.textLength))
                    .doneInjecting()

        }
    }
}