package com.pss.broadleaf.plugin

import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.psi.PsiElement

object ModuleHelper {

    private val ADMIN = Regex("admin")

    fun isAdminModule(element: PsiElement?): Boolean {
        val project = element?.project
        val file = element?.containingFile?.originalFile

        if(project != null && file != null && file.virtualFile != null) {
            val module = ProjectRootManager.getInstance(project).fileIndex.getModuleForFile(file.virtualFile)
            if(module != null){
                return module.name.contains(ADMIN)
            }
        }
        return false
    }
}