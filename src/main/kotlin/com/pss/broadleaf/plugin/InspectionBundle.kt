package com.pss.broadleaf.plugin

import com.intellij.CommonBundle
import org.jetbrains.annotations.PropertyKey
import java.lang.ref.Reference
import java.lang.ref.SoftReference
import java.util.*

object InspectionBundle {
    const val BUNDLE = "broadleaf.inspection-errors"
    var BUNDLE_REFERENCE: Reference<ResourceBundle>? = null;

    fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): String {
        return CommonBundle.message(getBundle(), key, params)
    }

    private fun getBundle(): ResourceBundle {
        var bundle: ResourceBundle? = com.intellij.reference.SoftReference.dereference(BUNDLE_REFERENCE)
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE)
            BUNDLE_REFERENCE = SoftReference(bundle)
        }
        return bundle!!
    }


}