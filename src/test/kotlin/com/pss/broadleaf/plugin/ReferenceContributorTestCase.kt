package com.pss.broadleaf.plugin

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.completion.LightFixtureCompletionTestCase
import com.intellij.testFramework.LightProjectDescriptor
import java.io.File
import org.assertj.core.api.Assertions.assertThat
import com.intellij.testFramework.PsiTestUtil
import com.intellij.openapi.vfs.newvfs.impl.VfsRootAccess
import com.intellij.testFramework.LightPlatformTestCase
import com.intellij.util.PathUtil
import com.intellij.psi.PsiElement




/**
 * Do I even use LightFixtureCompletionTestCase for Reference Completion??
 */
class ReferenceContributorTestCase : LightFixtureCompletionTestCase() {

    override fun getTestDataPath(): String {
        return File("testData").absoluteFile.path + "/reference"
    }



    fun testAdornedReferenceTarget(){
        configureByTestName();
        assertThat(myItems).hasSize(2)
        assertThat(myItems[0].allLookupStrings).containsOnly("basicEntity")

    }

    fun testAdornedReferenceMaintained(){
        configureByTestName();
        assertThat(myItems).hasSize(2)
        assertThat(myItems[0].allLookupStrings).containsOnly("date")
    }


    fun testAdornedReferenceGrid(){
        configureByTestName();

        assertThat(myItems).hasSize(2)
       // assertThat(myItems[0].allLookupStrings).containsOnly("date", "dascription")
    }



    override fun getProjectDescriptor(): LightProjectDescriptor {
        return Descriptor()
    }

}