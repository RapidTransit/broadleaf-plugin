package com.pss.broadleaf.plugin.html

import com.intellij.thymeleaf.lang.psi.ThymesSelectionsExpression
import com.intellij.thymeleaf.lang.psi.ThymesVisitor
import com.pss.broadleaf.plugin.ModuleHelper


class FixObjectContextVisitor : ThymesVisitor() {

    // Can't figure out how to fix it
    override fun visitSelectionsExpression(o: ThymesSelectionsExpression) {
        if(ModuleHelper.isAdminModule(o)){

        }
    }
}