package com.pss.broadleaf.plugin.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext
import com.pss.broadleaf.plugin.*

class AdornedCompletionContributor : CompletionContributor() {

    init {
        extend(CompletionType.BASIC, AdornedReferenceContributor.ANNOTATION, AdornedCompletionProvider())
    }

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        super.fillCompletionVariants(parameters, result)
    }

    class AdornedCompletionProvider : CompletionProvider<CompletionParameters>() {


        override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext?, result: CompletionResultSet) {
            val field = parameters.position.getField()
            if(field != null){
                if(field.isCollectionType() && !field.isMapType()){
                    val component = field.getCollectionComponent()
                    if (component != null) {
                        component.getAllFieldsOfType().forEach({
                            result.addElement(LookupElementBuilder.create(it))
                        })
                    }
                }
            }
        }

    }
}