package com.pss.broadleaf.plugin.html

import com.intellij.psi.xml.XmlDocument
import com.intellij.xml.HtmlXmlExtension

/**
 * Adds Thymeleaf th:* Name Space By Default
 *
 * Todo: Register framework-web-dialect.xml with Idea
 */
class ThymeleafExtraNS : HtmlXmlExtension() {

    override fun getNamespacesFromDocument(parent: XmlDocument?, declarationsExist: Boolean): Array<Array<String>>? {
        val ns = super.getNamespacesFromDocument(parent, declarationsExist)
        if(ns == null){
            return arrayOf(arrayOf("th", "http://www.thymeleaf.org"), arrayOf("blc", "http://www.broadleafcommerce.com"))
        } else {
            return ns.plus(arrayOf("th", "http://www.thymeleaf.org")).plus(arrayOf("blc", "http://www.broadleafcommerce.com"))
        }
    }

}