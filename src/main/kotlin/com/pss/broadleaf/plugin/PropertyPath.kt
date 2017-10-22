package com.pss.broadleaf.plugin

import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassType
import org.funktionale.collections.tail

class PropertyPath(val entry: PsiClass, path: String) {

    val classes: MutableCollection<PsiClass>
    val segments: List<String>
    val next: Segment

    init {
        classes = entry.getInheritorsWithThis()
        segments = StringUtil.split(path, ".")
        next = Segment(segments.first(), classes, "", segments.tail())
    }


    class Segment(val field: String, val entry: MutableCollection<PsiClass>, val path: String, val remainingSegments: List<String> = emptyList()) {
        val next: Segment?
        init {
            if(remainingSegments.isEmpty()){
                next = null
            } else {
                val first = remainingSegments.first()
                val entries = entry.mapNotNull { it.findFieldByName(first, true) }.map { it.type }.filterIsInstance(PsiClassType::class.java)
                        .mapNotNull { it.resolve() }
                        .flatMap { it.getInheritorsWithThis() }
                next = Segment(
                        field = first,
                        entry = entry,
                        path = if(path.isEmpty()) field else "$path.$field",
                        remainingSegments = remainingSegments.tail())
            }
        }
    }

}