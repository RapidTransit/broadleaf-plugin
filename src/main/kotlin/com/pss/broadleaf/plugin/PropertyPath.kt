package com.pss.broadleaf.plugin

import com.intellij.psi.PsiClass

class PropertyPath(entry: PsiClass, path: String) {

    val classes: List<PsiClass>
    val segments: List<String>

    init {

    }


    class Segment(field: String, entry: PsiClass, path: String, remainingSegments: List<String> = emptyList()) {

    }

}