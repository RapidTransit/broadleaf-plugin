package com.pss.broadleaf.plugin

import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiField
import org.funktionale.collections.tail

class PropertyPath(val entry: PsiClass, path: String) {

    val segments: List<String>
    val next: Segment

    init {
        segments = StringUtil.split(path, ".")
        next = Segment(segments.first(), entry.getInheritorsWithThis(), segments.tail())
    }

    fun isResolved(): Boolean {
        return next.isResolved()
    }

    fun resolve(): Segment {
        return next.resolve()
    }



    class Segment(val field: String, val entry: Collection<PsiClass>, val remainingSegments: List<String>) {

         val fields: List<PsiField>
        private val next: Segment?
        private val failed: Boolean
        init {
            fields = entry.mapNotNull { it.findFieldByName(field, true) }
            failed = fields.isEmpty()
            if(remainingSegments.isEmpty() || failed){
                next = null
            } else {
                next = Segment(remainingSegments.first(),
                        fields.map { it.type }
                                .filterIsInstance(PsiClassType::class.java)
                                .mapNotNull { it.resolve() }
                                .flatMap { it.findAllConcreteTypesWithThis() },
                        remainingSegments.tail()
                )
            }
        }

        fun resolve(): Segment {
            if(next != null){
                return next.resolve()
            }
            return this
        }

        fun isResolved(): Boolean {
            if(failed){
                return false
            } else {
                if(next != null){
                    return next.isResolved()
                } else {
                    return true
                }
            }
        }

    }

}