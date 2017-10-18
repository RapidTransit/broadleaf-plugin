package com.pss.broadleaf.plugin

import com.intellij.openapi.module.Module
import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.LanguageLevelModuleExtension
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.vfs.newvfs.impl.VfsRootAccess
import com.intellij.pom.java.LanguageLevel
import com.intellij.testFramework.LightProjectDescriptor
import com.intellij.testFramework.PsiTestUtil
import com.intellij.util.PathUtil
import java.io.File
import com.intellij.openapi.projectRoots.JavaSdk



class Descriptor : LightProjectDescriptor(){

    private val BUILD_LIBS_DIRECTORY = "build/libs"
    private val BUILD_MOCK_JDK_DIRECTORY = "build/mockJDK-"

    override fun getSdk(): Sdk? {

        return JavaAwareProjectJdkTableImpl.getInstanceEx().internalJdk
//        val compilerOption = LanguageLevel.JDK_1_8.getCompilerComplianceDefaultOption()
//        return JavaSdk.getInstance()
//                .createJdk("java " + compilerOption, BUILD_MOCK_JDK_DIRECTORY + compilerOption, false)
    }

    override fun configureModule(module: Module, model: ModifiableRootModel, contentEntry: ContentEntry) {

        model.getModuleExtension(LanguageLevelModuleExtension::class.java).setLanguageLevel(LanguageLevel.JDK_1_8)
        val lib = PathUtil.toSystemIndependentName(File("lib").absoluteFile.path);
        VfsRootAccess.allowRootAccess(lib);
        PsiTestUtil.addLibrary(module, model, "broadleaf-common", lib + '/', "broadleaf-common-5.2.0-GA.jar")
        PsiTestUtil.addLibrary(module, model, "hibernate-jpa-2.0-api", lib, "hibernate-jpa-2.0-api-1.0.1.Final.jar")
        PsiTestUtil.addLibrary(module, model, "hibernate-core", lib, "hibernate-core-4.1.11.Final.jar")
    }
}