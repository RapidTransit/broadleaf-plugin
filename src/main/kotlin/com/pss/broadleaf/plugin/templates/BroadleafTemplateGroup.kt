package com.pss.broadleaf.plugin.templates

import com.intellij.codeInsight.template.impl.TemplateGroup
import com.intellij.ide.fileTemplates.FileTemplateDescriptor
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory
import com.pss.broadleaf.plugin.icons.BroadleafIcons

class BroadleafTemplateGroup : FileTemplateGroupDescriptorFactory {

    override fun getFileTemplatesDescriptor(): FileTemplateGroupDescriptor {
        return FileTemplateGroupDescriptor("Broadleaf Templates", BroadleafIcons.BLC,
                FileTemplateDescriptor("/broadleaf/templates/broadleaf-enumeration.java"),
                FileTemplateDescriptor("/broadleaf/templates/broadleaf-entity.java"))
    }
}