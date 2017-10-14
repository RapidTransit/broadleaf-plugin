package com.pss.broadleaf.plugin.html

import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiVariable
import com.intellij.psi.util.PropertyUtil
import com.intellij.psi.util.PsiTypesUtil
import com.intellij.thymeleaf.lang.support.ThymeleafContextVariablesProvider
import com.intellij.thymeleaf.lang.support.beans.ThymeleafVariable
import com.pss.broadleaf.plugin.BroadleafConstants.ThymeleafContextVariables
import com.pss.broadleaf.plugin.ModuleHelper
import org.broadleafcommerce.openadmin.dto.Entity
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm

import java.util.*

class BroadleafAdminContextVariablesProvider : ThymeleafContextVariablesProvider() {

    override fun getContextVariables(element: PsiElement): MutableCollection<out PsiVariable> {
        if(ModuleHelper.isAdminModule(element)){
            val psiFacade = JavaPsiFacade.getInstance(element.project)
            val scope = element.resolveScope
            val collection = mutableSetOf<PsiVariable>()
            ThymeleafContextVariables.MODEL.forEach { key, value ->
                psiFacade.findClass(value, scope)?.let {
                    val type = PsiTypesUtil.getClassType(it)
                    collection.add(ThymeleafVariable(key, type, it.navigationElement))
                }
            }
            ThymeleafContextVariables.EXPRESSIONS.forEach { key, value ->
                psiFacade.findClass(value, scope)?.let {
                    val type = PsiTypesUtil.getClassType(it)
                    collection.add(ThymeleafVariable(key, type, it.navigationElement))
                }

            }
            return collection
        }
        return Collections.emptySet()
    }
}