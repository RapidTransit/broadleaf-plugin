package com.pss.broadleaf.plugin.inspections

import com.intellij.codeInspection.BaseJavaLocalInspectionTool
import com.intellij.codeInspection.LocalInspectionToolSession
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.lang.jvm.JvmModifier
import com.intellij.psi.*
import com.intellij.psi.util.PsiTypesUtil
import com.intellij.psi.util.PsiUtil


/**
 * Checks if org.broadleafcommerce.common.classloader.release.ThreadLocalManager#createThreadLocal(Class) is called
 * with a class that has a no-arg constructor
 */
class ThreadLocalManagerInspection : BaseJavaLocalInspectionTool(){

    override fun getID(): String {
        return "ThreadLocalManagerInspection"
    }

    override fun getDisplayName(): String {
        return "Thread Local Def Cons"
    }


    override fun getStaticDescription(): String? {
        return """
                Checks if org.broadleafcommerce.common.classloader.release.ThreadLocalManager#createThreadLocal(Class) is called
                with a class that has a no-arg constructor
            """
    }

    override fun getGroupDisplayName(): String = "BLC"

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
                        holder.registerProblem(field, "ThreadLocal called without ThreadLocalManager", ProblemHighlightType.ERROR)
                        return
                    }
                    val method = (methodCall as PsiMethodCallExpression).resolveMethod()
                    if(method != null  && (method.name != "createThreadLocal"
                            || method.containingClass?.qualifiedName != "org.broadleafcommerce.common.classloader.release.ThreadLocalManager")){
                        holder.registerProblem(field, "ThreadLocal called without ThreadLocalManager", ProblemHighlightType.ERROR)
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
                            holder.registerProblem(expression, "Class is an interface and can not be initialized, please use only concrete classes", ProblemHighlightType.ERROR)
                            return
                        }
                        if (clazz.hasModifier(JvmModifier.ABSTRACT)) {
                            holder.registerProblem(expression, "Class is abstract and can not be initialized, please use only concrete classes", ProblemHighlightType.ERROR)
                            return
                        }
                        if (clazz.constructors.isNotEmpty()) {
                            val cons = clazz.constructors.find { it.parameters.isEmpty() }
                            if (cons == null) {
                                holder.registerProblem(expression, "Class has no no-arg constructor and can not be initialized", ProblemHighlightType.ERROR)
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
                    && (method.parameters.size == 1 || (method.parameters.size == 2 && method.parameters[1] is PsiLiteralExpression && (method.parameters[1] as PsiLiteralExpression).text.equals("true", true)))
                    && method.name == "createThreadLocal"
                    && method.containingClass?.qualifiedName == "org.broadleafcommerce.common.classloader.release.ThreadLocalManager"
        }
    }
}