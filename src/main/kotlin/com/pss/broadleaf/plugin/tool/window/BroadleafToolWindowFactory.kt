package com.pss.broadleaf.plugin.tool.window

import com.intellij.ide.scopeView.nodes.ClassNode
import com.intellij.ide.scopeView.nodes.FieldNode
import com.intellij.ide.scopeView.nodes.MemberNode

import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.project.DumbServiceImpl
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.psi.*
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.psi.util.PsiTypesUtil
import com.intellij.refactoring.ui.ClassCellRenderer
import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBTabbedPane
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.treeStructure.Tree
import com.pss.broadleaf.plugin.BroadleafConstants
import com.pss.broadleaf.plugin.BroadleafConstants.FrameworkTypes
import org.intellij.lang.annotations.MagicConstant
import javax.swing.DefaultListModel
import javax.swing.JPanel
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.DefaultTreeModel

class BroadleafToolWindowFactory : ToolWindowFactory {

    lateinit var panel: JPanel
    lateinit var tabpane: JBTabbedPane
    lateinit var extensionManagersTree: Tree
    lateinit var enumerationsTree: Tree
    lateinit var persistenceHandlersList: JBList<PsiClass>
    lateinit var toolWindow: ToolWindow

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {

        this.toolWindow = toolWindow;
        val factory = ContentFactory.SERVICE.getInstance()
        val scope = GlobalSearchScope.allScope(project);
        val service = DumbServiceImpl.getInstance(project)
        service?.runWhenSmart({
            val psiFacade = JavaPsiFacade.getInstance(project)

            createClassTree(extensionManagersTree, project, { model, root ->
                psiFacade.findClass(FrameworkTypes.EXTENSION_MANAGER, scope)?.let{
                    ClassInheritorsSearch.search(it, scope, true).findAll().sortedBy { it.name }.forEach { extensionManager ->
                        val top = DefaultMutableTreeNode(extensionManager.name)
                        model.insertNodeInto(top, root, root.childCount)

                        // Get The Parameter Type, this gets the Handler Type
                        extensionManager.extendsListTypes.first().parameters.first()?.let{
                            psiFacade.findClass(it.canonicalText, scope)?.let{
                                ClassInheritorsSearch.search(it, scope, true).forEach({
                                    if(!it.hasModifierProperty(PsiModifier.ABSTRACT)) {
                                        top.add(ClassNode(it))
                                    }
                                })
                            }
                        }
                    }
                }
            })

            createClassTree(enumerationsTree, project, {model, root ->
                psiFacade.findClass(FrameworkTypes.BROADLEAF_ENUMERATION_TYPE, scope)?.let {
                    val type = PsiTypesUtil.getClassType(it)

                    // Find All Direct Inheritors
                    ClassInheritorsSearch.search(it, scope, false).findAll().sortedBy { it.name }.forEach {
                        val fields = mutableListOf<PsiField>()

                        it.fields.filter { isEnumField(it, type) }.toCollection(fields)

                        // Find User's own Types
                        ClassInheritorsSearch.search(it).findAll().forEach {
                            it.fields.filter { isEnumField(it, type) }.toCollection(fields)
                        }
                        val top = DefaultMutableTreeNode(it.name)
                        fields.sortedBy { it.name }.forEach {
                            top.add(FieldNode(it))
                        }
                        model.insertNodeInto(top, root, root.childCount)
                    }
                }

            })

            psiFacade.findClass(FrameworkTypes.CUSTOM_PERSISTENCE_HANDLER, scope)?.let {
                val model = DefaultListModel<PsiClass>()

                ClassInheritorsSearch.search(it).findAll().sortedBy { it.name }.forEach {
                    //model.addElement(SmartPointerManager.getInstance(it.project).createSmartPsiElementPointer(it))
                    model.addElement(it)
                }
                persistenceHandlersList.cellRenderer = ClassCellRenderer(persistenceHandlersList.cellRenderer)
                persistenceHandlersList.model = model
                persistenceHandlersList.addListSelectionListener {
                    if(it.lastIndex < persistenceHandlersList.model.size) {
                        persistenceHandlersList.model.getElementAt(it.lastIndex)?.let {
                            OpenFileDescriptor(project, it.navigationElement.containingFile.virtualFile).navigate(true)
                        }
                    }
                }
            }

            val content = factory.createContent(panel, "", false)
            toolWindow.contentManager.addContent(content)
        })
    }

    fun isEnumField(field: PsiField, type: PsiType): Boolean {
        return field.hasModifierProperty(PsiModifier.PUBLIC) && field.hasModifierProperty(PsiModifier.STATIC) && type.isAssignableFrom(field.type)
    }

    fun createClassTree(tree: Tree, project: Project, func: (model: DefaultTreeModel, root: DefaultMutableTreeNode)-> Unit){
        val model = tree.model as DefaultTreeModel
        val root = model.root as DefaultMutableTreeNode
        root.removeAllChildren()
        func(model, root)
        model.reload()
        tree.addTreeSelectionListener {
            val source = extensionManagersTree.lastSelectedPathComponent
            if(source is MemberNode<*>){
                 source.psiElement?.let {  OpenFileDescriptor(project, it.navigationElement.containingFile.virtualFile).navigate(true) }
            }
        }
    }
}