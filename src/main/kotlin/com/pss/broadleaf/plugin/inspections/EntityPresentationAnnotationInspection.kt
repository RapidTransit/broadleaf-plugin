package com.pss.broadleaf.plugin.inspections

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.codeInspection.BaseJavaLocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTypesUtil
import com.siyeh.ig.psiutils.TypeUtils
import org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection
import org.broadleafcommerce.common.presentation.AdminPresentationCollection
import javax.persistence.Entity

class EntityPresentationAnnotationInspection : BaseJavaLocalInspectionTool() {

    companion object {
        val ENTITY = "javax.persistence.Entity"
        val MAPPED_SUPER_CLASS = "javax.persistence.MappedSuperclass"
        val EMBEDDABLE = "javax.persistence.Embeddable"
        val MANAGED_TYPES = setOf<String>(ENTITY, MAPPED_SUPER_CLASS, EMBEDDABLE)
        val PRESENTATION_COLLECTION = "org.broadleafcommerce.common.presentation.AdminPresentationCollection"
        val PRESENTATION = "org.broadleafcommerce.common.presentation.AdminPresentation"
        val PRESENTATION_TO_ONE = "org.broadleafcommerce.common.presentation.AdminPresentationToOneLookup"
        val ADORNED_TARGET = "org.broadleafcommerce.common.presentation.AdminPresentationAdornedTargetCollection"
    }

    override fun getDisplayName(): String {
        return "Entity Presentation"
    }

    override fun getStaticDescription(): String? {
        return "Checks Entity's Have Correct PresentationAttributes"
    }

    override fun getGroupDisplayName(): String {
        return "BLC"
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return EntityPresentationVisitor(holder)
    }

    class EntityPresentationVisitor(private val holder: ProblemsHolder) : JavaElementVisitor() {

        override fun visitClass(aClass: PsiClass?) {
            if (aClass != null) {

                if(AnnotationUtil.findAnnotation(aClass, MANAGED_TYPES) != null){
                    aClass.allFields.forEach {
                        if(AnnotationUtil.isAnnotated(it, setOf("org.broadleafcommerce.common.presentation.AdminPresentationCollection"))){
                            if(AnnotationUtil.isAnnotated(it, setOf("org.broadleafcommerce.common.presentation.AdminPresentation"))){
                                holder.registerProblem(AnnotationUtil.findAnnotation(it, "org.broadleafcommerce.common.presentation.AdminPresentation")!!.originalElement, "Field Containes Both Annotation Types", ProblemHighlightType.ERROR)
                            }
                            val collection = JavaPsiFacade.getInstance(aClass.project).findClass("java.util.Collection", aClass.resolveScope)
                            if(collection != null) {
                                val type = TypeUtils.getType(collection)
                                if(!type.isAssignableFrom(it.type)){
                                    holder.registerProblem(it, "Field is not a Collection Type", ProblemHighlightType.ERROR)
                                }
                            }
                            return
                        }


                    }
                }
            }
        }

        inline fun <T>notNull(t: T, function: (T) -> Unit): Unit {
            if(t != null){
                function(t)
            }
        }
    }
}