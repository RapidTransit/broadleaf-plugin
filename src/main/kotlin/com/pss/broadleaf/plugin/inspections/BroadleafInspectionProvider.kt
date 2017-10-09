package com.pss.broadleaf.plugin.inspections

import com.intellij.codeInspection.InspectionToolProvider

class BroadleafInspectionProvider : InspectionToolProvider {
    override fun getInspectionClasses(): Array<Class<Any>> {
        return arrayOf(ThreadLocalManagerInspection::class.java, EntityPresentationAnnotationInspection::class.java) as Array<Class<Any>>
    }
}