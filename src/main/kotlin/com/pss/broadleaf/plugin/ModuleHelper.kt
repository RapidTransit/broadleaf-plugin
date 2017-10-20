package com.pss.broadleaf.plugin

import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiElement

object ModuleHelper {

    private val ADMIN = Regex("admin")
    private val IS_ADMIN = Key<Boolean>("IS_ADMIN")
    fun isAdminModule(element: PsiElement?): Boolean {
        if(element != null) {
            return element.cacheGet(IS_ADMIN, {
            val project = element.project
            val file = element.containingFile?.originalFile
            if (project != null && file != null && file.virtualFile != null) {
                val module = ProjectRootManager.getInstance(project).fileIndex.getModuleForFile(file.virtualFile)
                if (module != null) {
                    return module.name.contains(ADMIN)
                }
            }
                return false
            })

        }
        return false
    }
}