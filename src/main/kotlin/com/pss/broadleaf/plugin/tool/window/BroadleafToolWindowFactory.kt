package com.pss.broadleaf.plugin.tool.window

import com.intellij.codeInsight.navigation.MethodImplementationsSearch
import com.intellij.ide.scopeView.nodes.ClassNode
import com.intellij.lang.jvm.JvmModifier
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.progress.ProgressManager
import com.intellij.openapi.project.DumbServiceImpl
import com.intellij.openapi.project.ModuleListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileListener
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiManager
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.GlobalSearchScopeUtil
import com.intellij.psi.search.searches.AnnotationTargetsSearch
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.ui.TabbedPane
import com.intellij.ui.content.ContentFactory
import org.broadleafcommerce.common.extension.ExtensionManager
import javax.swing.JPanel
import javax.swing.JTabbedPane
import javax.swing.JTree
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel

class BroadleafToolWindowFactory : ToolWindowFactory {



    lateinit var panel: JPanel
    lateinit var tabpane: JTabbedPane
    lateinit var extensionManagersTree: JTree
    lateinit var toolWindow: ToolWindow

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        this.toolWindow = toolWindow;
        val root = extensionManagersTree.model.root as DefaultMutableTreeNode
        root.removeAllChildren()
        val factory = ContentFactory.SERVICE.getInstance()
        val scope = GlobalSearchScope.everythingScope(project);
        val service = DumbServiceImpl.getInstance(project)
        service?.runWhenSmart( {

            val clazz = JavaPsiFacade.getInstance(project).findClass("org.broadleafcommerce.common.extension.ExtensionManager", scope)
            JavaPsiFacade.getInstance(project)

            if (clazz != null) {
                val search = ClassInheritorsSearch.search(clazz, scope, true)
                val model = extensionManagersTree.model as DefaultTreeModel

                search.findAll().sortedBy { it.name }.forEach {
                    val top = DefaultMutableTreeNode(it.name)
                    model.insertNodeInto(top, root, root.childCount)
                    val generic = it.extendsListTypes.first().parameters.first()
                    if(generic != null) {
                        val clazz2 = JavaPsiFacade.getInstance(project).findClass(generic.canonicalText, scope)
                        if(clazz2 != null) {
                            ClassInheritorsSearch.search(clazz2, scope, true).forEach({
                                if(!it.hasModifier(JvmModifier.ABSTRACT)) {
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

                        OpenFileDescriptor(project, source.containingFile.virtualFile).navigate(true)
                    }
                })
            }
            val content = factory.createContent(panel, "", false)
            toolWindow.contentManager.addContent(content)
        })
    }
}