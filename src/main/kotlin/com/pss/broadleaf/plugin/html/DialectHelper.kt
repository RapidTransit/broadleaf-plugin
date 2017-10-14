package com.pss.broadleaf.plugin.html

import java.net.URL

object DialectHelper {

    fun getSiteDialect(): URL {
            return DialectHelper::class.java.getResource("/broadleaf/bl-framework-web-dialect.xml")!!
    }

    fun getAdminDialect(): URL {
        return DialectHelper::class.java.getResource("/broadleaf/bl-framework-admin-dialect.xml")!!
    }
}