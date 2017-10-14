package com.pss.broadleaf.plugin.html

import com.intellij.psi.xml.XmlDocument
import com.intellij.xml.HtmlXmlExtension
import com.sun.javafx.scene.CameraHelper.project
import com.intellij.openapi.roots.ProjectRootManager
import com.pss.broadleaf.plugin.ModuleHelper


/**
 * Adds Thymeleaf th:* Name Space By Default
 *
 */
class ThymeleafExtraNS : HtmlXmlExtension() {

    override fun getNamespacesFromDocument(parent: XmlDocument?, declarationsExist: Boolean): Array<Array<String>>? {
        val ns = super.getNamespacesFromDocument(parent, declarationsExist)
        if(ModuleHelper.isAdminModule(parent)){
            if(ns == null){
                return arrayOf(arrayOf("th", "http://www.thymeleaf.org"), arrayOf("blc", "http://www.broadleafcommerce.com/"), arrayOf("blc_admin", "http://www.broadleafcommerce.com/"))
            } else {
                return ns.plus(arrayOf("th", "http://www.thymeleaf.org")).plus(arrayOf("blc", "http://www.broadleafcommerce.com/")).plus(arrayOf("blc_admin", "http://www.broadleafcommerce.com/"))
            }
        } else {
            if(ns == null){
                return arrayOf(arrayOf("th", "http://www.thymeleaf.org"), arrayOf("blc", "http://www.broadleafcommerce.com/"))
            } else {
                return ns.plus(arrayOf("th", "http://www.thymeleaf.org")).plus(arrayOf("blc", "http://www.broadleafcommerce.com/"))
            }
        }

    }

}