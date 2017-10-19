package com.pss.broadleaf.plugin.templates

import com.intellij.codeInsight.template.impl.TemplateGroup
import com.intellij.ide.fileTemplates.*
import com.pss.broadleaf.plugin.icons.BroadleafIcons

class BroadleafTemplateGroup : FileTemplateGroupDescriptorFactory {

    override fun getFileTemplatesDescriptor(): FileTemplateGroupDescriptor {
        val templates =  FileTemplateGroupDescriptor("Broadleaf Templates", BroadleafIcons.BLC)
        templates.addTemplate(FileTemplateDescriptor("BroadleafEnumeration.java", BroadleafIcons.BLC))
        templates.addTemplate(FileTemplateDescriptor("BroadleafEntity.java", BroadleafIcons.BLC))
        return templates
    }
}