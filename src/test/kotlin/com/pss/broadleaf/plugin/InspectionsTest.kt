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
    fun testEntityBadMapTypes(){
        doTest()
    }

    fun testEntityBadStringTypes(){
        doTest()
    }

    fun testEntityBadBooleanTypes(){
        doTest()
    }

    fun testEntityBadIntegerTypes(){
        doTest()
    }
    fun testEntityBadEmailTypes(){
        doTest()
    }

    fun testEntityBadPasswordTypes(){
        doTest()
    }

    fun testEntityBadDescriptionTypes(){
        doTest()
    }


    fun testEntityBadPasswordConfirmTypes(){
        doTest()
    }

    fun testEntityBadDecimalTypes(){
        doTest()
    }

    fun testEntityBadMoneyTypes(){
        doTest()
    }

    override fun getProjectDescriptor(): LightProjectDescriptor {
        return Descriptor()
    }

}