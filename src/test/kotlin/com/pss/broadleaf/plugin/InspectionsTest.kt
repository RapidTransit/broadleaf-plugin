package com.pss.broadleaf.plugin

import com.intellij.codeInspection.InspectionProfileEntry
import com.intellij.openapi.module.Module
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.newvfs.impl.VfsRootAccess
import com.intellij.testFramework.InspectionTestCase
import com.intellij.testFramework.LightProjectDescriptor
import com.intellij.testFramework.PsiTestUtil
import com.intellij.util.PathUtil
import com.pss.broadleaf.plugin.inspections.EntityPresentationAnnotationInspection
import com.siyeh.ig.LightInspectionTestCase
import java.io.File
import com.intellij.openapi.roots.LanguageLevelModuleExtension
import com.intellij.pom.java.LanguageLevel
import org.jetbrains.jps.model.serialization.JpsModelSerializationDataService.getModuleExtension



class InspectionsTest : LightInspectionTestCase() {
    override fun getInspection(): InspectionProfileEntry? {
        return EntityPresentationAnnotationInspection()
    }



    override fun getTestDataPath(): String {

        return File("testData").absoluteFile.path + "/inspections"
    }

    fun testEntityBadTypes(){
        doTest()
    }

    override fun getProjectDescriptor(): LightProjectDescriptor {
        return Descriptor()
    }

    class Descriptor : LightProjectDescriptor(){
        override fun getSdk(): Sdk? {
            return JavaAwareProjectJdkTableImpl.getInstanceEx().internalJdk
        }

        override fun configureModule(module: Module, model: ModifiableRootModel, contentEntry: ContentEntry) {
            model.getModuleExtension(LanguageLevelModuleExtension::class.java).setLanguageLevel(LanguageLevel.JDK_1_8)
            val lib = PathUtil.toSystemIndependentName(File("lib").absoluteFile.path);
            VfsRootAccess.allowRootAccess(lib);
            PsiTestUtil.addLibrary(module, model, "broadleaf-common", lib + '/', "broadleaf-common-5.2.0-GA.jar")
            PsiTestUtil.addLibrary(module, model, "hibernate-jpa-2.0-api", lib, "hibernate-jpa-2.0-api-1.0.1.Final.jar")
        }
    }
}