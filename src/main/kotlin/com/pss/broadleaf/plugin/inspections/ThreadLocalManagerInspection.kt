package com.pss.broadleaf.plugin.inspections

import com.intellij.codeInspection.BaseJavaLocalInspectionTool
import com.intellij.codeInspection.LocalInspectionToolSession
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.*
import com.intellij.psi.util.PsiTypesUtil
import com.intellij.psi.util.PsiUtil


/**
 * Checks if org.broadleafcommerce.common.classloader.release.ThreadLocalManager#createThreadLocal(Class) is called
 * with a class that has a no-arg constructor
 */
class ThreadLocalManagerInspection : BaseJavaLocalInspectionTool(){

    override fun getID(): String = "ThreadLocalManagerInspection"


    override fun getDisplayName(): String = "Broadleaf Thread Local Issues"

    override fun getGroupDisplayName(): String = "BLC"

    override fun getStaticDescription(): String? =
"""
    Checks to make sure all ThreadLocals are initiated with org.broadleafcommerce.common.classloader.release.ThreadLocalManager
    which cleans up Thread Locals after each Web Request it also checks if
    org.broadleafcommerce.common.classloader.release.ThreadLocalManager#createThreadLocal(Class) is called with a class
    that has a no-arg constructor
"""

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return ThreadLocalManagerVisitor(holder)
    }


    class ThreadLocalManagerVisitor(private val holder: ProblemsHolder) : JavaElementVisitor() {

        override fun visitField(field: PsiField?) {
            if (field != null) {
                val clazz = PsiTypesUtil.getPsiClass(field.type)
                if(clazz != null && clazz.qualifiedName.equals("java.lang.ThreadLocal")){
                    val methodCall = field.children.find { it is PsiMethodCallExpression }
                    if(methodCall == null){
                        holder.registerProblem(field.initializer?:field, "ThreadLocal called without ThreadLocalManager")
                        return
                    }
                    val method = (methodCall as PsiMethodCallExpression).resolveMethod()
                    if(method != null  && (method.name != "createThreadLocal"
                            || method.containingClass?.qualifiedName != "org.broadleafcommerce.common.classloader.release.ThreadLocalManager")){
                        holder.registerProblem(methodCall, "ThreadLocal called without ThreadLocalManager")
                    }
                }
            }
        }

        override fun visitMethodCallExpression(expression: PsiMethodCallExpression?) {
            if (expression != null) {
                val method = expression.resolveMethod()
                if (isInitialized(method)) {
                    val expr = expression.argumentList.expressions.first()
                    if(expr is PsiClassObjectAccessExpression){
                    val clazz2 = expr.operand
                    val clazz = PsiUtil.resolveClassInClassTypeOnly(clazz2.type.deepComponentType)
                    if (clazz is PsiClass) {
                        if (clazz.isInterface) {
                            holder.registerProblem(expression.argumentList.expressions.first(), "Class is an interface and can not be initialized, please use only concrete classes", ProblemHighlightType.ERROR)
                            return
                        }
                        if (clazz.hasModifierProperty(PsiModifier.ABSTRACT)) {
                            holder.registerProblem(expression.argumentList.expressions.first(), "Class is abstract and can not be initialized, please use only concrete classes", ProblemHighlightType.ERROR)
                            return
                        }
                        if (clazz.constructors.isNotEmpty()) {
                            val cons = clazz.constructors.find { it.parameterList.parametersCount == 0 }
                            if (cons == null) {
                                holder.registerProblem(expression.argumentList.expressions.first(), "Class has no no-arg constructor and can not be initialized", ProblemHighlightType.ERROR)
                                return
                            }

                        }
                    }


                    }
                }
            }
        }

        private fun isInitialized(method: PsiMethod?): Boolean {
            return method != null
                    && (method.parameterList.parametersCount == 1 || (method.parameterList.parametersCount == 2 && method.parameterList.parameters[1] is PsiLiteralExpression && (method.parameterList.parameters[1] as PsiLiteralExpression).text.equals("true", true)))
                    && method.name == "createThreadLocal"
                    && method.containingClass?.qualifiedName == "org.broadleafcommerce.common.classloader.release.ThreadLocalManager"
        }
    }
}