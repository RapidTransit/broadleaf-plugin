package com.pss.broadleaf.plugin.tool.window

import com.intellij.codeInsight.navigation.ClassImplementationsSearch
import com.intellij.codeInsight.navigation.MethodImplementationsSearch
import com.intellij.ide.scopeView.nodes.ClassNode

import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.project.DumbService
import com.intellij.openapi.project.DumbServiceImpl
import com.intellij.openapi.project.ModuleListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileListener
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.psi.*
import com.intellij.psi.impl.smartPointers.SmartPsiElementPointerImpl
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.GlobalSearchScopeUtil
import com.intellij.psi.search.searches.AnnotationTargetsSearch
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.ui.TabbedPane
import com.intellij.ui.components.JBTabbedPane
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.tabs.JBTabs
import com.intellij.ui.treeStructure.Tree
import com.pss.broadleaf.plugin.BroadleafConstants.FrameworkTypes
import org.broadleafcommerce.common.extension.ExtensionManager
import javax.swing.JPanel
import javax.swing.JTabbedPane
import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel

class BroadleafToolWindowFactory : ToolWindowFactory {

    lateinit var panel: JPanel
    lateinit var tabpane: JBTabbedPane
    lateinit var extensionManagersTree: Tree
    lateinit var toolWindow: ToolWindow

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

        this.toolWindow = toolWindow;
        val root = extensionManagersTree.model.root as DefaultMutableTreeNode
        root.removeAllChildren()
        val factory = ContentFactory.SERVICE.getInstance()
        val scope = GlobalSearchScope.allScope(project);
        val service = DumbServiceImpl.getInstance(project)
        service?.runWhenSmart( {
            val psiFacade = JavaPsiFacade.getInstance(project)
            psiFacade.findClass(FrameworkTypes.EXTENSION_MANAGER, scope)?.let{
                val search = ClassInheritorsSearch.search(it, scope, true)
                val model = extensionManagersTree.model as DefaultTreeModel
                search.findAll().sortedBy { it.name }.forEach {
                    val top = DefaultMutableTreeNode(it.name)
                    model.insertNodeInto(top, root, root.childCount)
                    it.extendsListTypes.first().parameters.first()?.let{

                        psiFacade.findClass(it.canonicalText, scope)?.let{
                            ClassInheritorsSearch.search(it, scope, true).forEach({
                                if(!it.hasModifierProperty(PsiModifier.ABSTRACT)) {
                                    top.add(ClassNode(it))
                                }
                            })
                        }

                    }
                }
                model.reload(root)
                extensionManagersTree.addTreeSelectionListener({
                    val source = extensionManagersTree.lastSelectedPathComponent
                    if(source is ClassNode){
                        source.psiElement?.let {
                            OpenFileDescriptor(project, it.navigationElement.containingFile.virtualFile).navigate(true)
                        }
                    }
                })
            }
            psiFacade.findClass(FrameworkTypes.BROADLEAF_ENUMERATION_TYPE, scope)?.let {
                ClassInheritorsSearch.search(it, scope, false).findAll().forEach {

                }
            }
            val content = factory.createContent(panel, "", false)
            toolWindow.contentManager.addContent(content)
        })
    }
}