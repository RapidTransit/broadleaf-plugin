package com.pss.broadleaf.plugin

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.psi.*
import com.intellij.psi.impl.PsiClassImplUtil
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.pss.broadleaf.plugin.completion.AdornedReferenceContributor
import com.siyeh.ig.PsiReplacementUtil
import com.siyeh.ig.psiutils.CollectionUtils
import com.intellij.psi.util.InheritanceUtil;
import com.intellij.psi.util.PsiTypesUtil
import com.intellij.psi.util.parentsOfType
import com.siyeh.ig.psiutils.TypeUtils
import org.jetbrains.annotations.NotNull
import java.util.*

object Utils {
    fun isFieldAnnotated(listOwner: PsiModifierListOwner, annotationFQN: String ): Boolean {
        return AnnotationUtil.isAnnotated(listOwner, annotationFQN, false, true, true)
    }

    fun getField(element: PsiElement): PsiField? {
        if(element is PsiField){
            return element;
        }
        var parent: PsiElement? = element;
        while(parent != null) {
            parent = parent.parent
            if (parent is PsiField) {
                return parent
            }
        }
        return null
    }

    fun containsAnnotation(type: PsiType, fqn: Set<String>): Boolean {
        val clazz = PsiTypesUtil.getPsiClass(type)
        if(clazz != null){
            if(clazz.isInterface){
                return ClassInheritorsSearch.search(clazz, true ).findAll()
                        .any { !it.isInterface && it.isAnnotated(fqn) }
            } else {
                return clazz.isAnnotated(fqn)
            }
        }
        return false
    }

    fun containsAnnotation(type: PsiType, fqn: String): Boolean {
        val clazz = PsiTypesUtil.getPsiClass(type)
        if(clazz != null){
            return containsAnnotation(clazz, fqn)
        }
        return false
    }

    fun containsAnnotation(clazz: PsiClass, fqn: String): Boolean {

        if(clazz.isInterface){
            return ClassInheritorsSearch.search(clazz, true ).findAll()
                    .any { !it.isInterface && it.isAnnotated(fqn) }
        } else {
            return clazz.isAnnotated(fqn)
        }
    }

}
fun PsiElement.getField(): PsiField? {
    if(this is PsiField){
        return this;
    }
    var parent = this;
    while(parent != null) {
        parent = parent?.parent
        if (parent is PsiField) {
            return parent
        }
    }
    return null
}

fun PsiField.isCollectionType(): Boolean {
    return CollectionUtils.isCollectionClassOrInterface(this.type)
}

fun PsiField.isSimpleType(): Boolean {
    val type = PsiTypesUtil.getPsiClass(this.type)
    return BroadleafConstants.AcceptableTypes.SIMPLE.contains(type?.qualifiedName)
}

fun PsiField.isMapType(): Boolean {
    return InheritanceUtil.isInheritor(this.type, CommonClassNames.JAVA_UTIL_MAP)
}

fun PsiField.doWithAnnotation(annotationFQN: Set<String>, function: (PsiField, PsiAnnotation)->Unit){
    val annotation = AnnotationUtil.findAnnotation(this, annotationFQN, true)
    if(annotation != null){
        function(this, annotation)
    }
}

fun PsiClass.findPsiClass(fqn: String): PsiClass? {
    return JavaPsiFacade.getInstance(this.project).findClass(fqn, this.resolveScope)
}

fun PsiClass.findPsiType(fqn: String): PsiType? {
    return  TypeUtils.getType(fqn, this)
}

fun PsiClass.isAssignable(fqn: Set<String>, type: PsiType): Boolean {
    return fqn.mapNotNull { TypeUtils.getType(it, this) }.any { type.isAssignableFrom(it) }
}
fun PsiClass.isAssignable(fqn: String, type: PsiType): Boolean {
    val t = TypeUtils.getType(fqn, this)
    if(t != null){
        return type.isAssignableFrom(t)
    }
    return false
}

fun PsiField.getAnnotation(annotationFQN: Set<String>): PsiAnnotation? {
    return AnnotationUtil.findAnnotation(this, annotationFQN, true)
}

fun PsiField.isAnnotated(annotationFQN: String): Boolean {
    return AnnotationUtil.isAnnotated(this, annotationFQN, false, true, true)
}
fun PsiField.isAnnotated(annotationFQN: Set<String>): Boolean {
    return annotationFQN.any { AnnotationUtil.isAnnotated(this, it, false, true, true) }
}

fun PsiClass.isAnnotated(annotationFQN: Set<String>): Boolean {
    return annotationFQN.any { AnnotationUtil.isAnnotated(this, it, false, true, true) }
}
fun PsiClass.isAnnotated(annotationFQN: String): Boolean {
    return AnnotationUtil.isAnnotated(this, annotationFQN, false, true, true)
}

fun PsiType.isManaged(): Boolean {
    return Utils.containsAnnotation(this, BroadleafConstants.AcceptableTypes.MANAGED_TYPES)
}

fun PsiType.isEntity(): Boolean {
    return Utils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Entity.CLASS_NAME)
}

fun PsiType.isEmbeddable(): Boolean {
    return Utils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Embeddable.CLASS_NAME)
}

fun PsiType.findAllConcreteTypes(): Collection<PsiClass> {
    val clazz = PsiTypesUtil.getPsiClass(this)
    if(clazz != null) {
        return ClassInheritorsSearch.search(clazz, true).findAll().filter { !it.isInterface }
    }
    return emptySet()
}

fun PsiClass.findAllConcreteTypes(): Collection<PsiClass> {

        return ClassInheritorsSearch.search(this, true).findAll().filter { !it.isInterface }

}

fun PsiClass.getFields(name: String): Collection<PsiField> {
    return this.findAllConcreteTypes().flatMap { it.fields.asList() }.filter { it.name == name }
}

fun PsiType.getFields(name: String): Collection<PsiField> {
    return this.findAllConcreteTypes().flatMap { it.fields.asList() }.filter { it.name == name }
}

fun PsiField.getCollectionComponent(): PsiClass? {
    val type = this.type
    if(type is PsiClassType && type.hasParameters()){
        val parameter = type.parameters.first()
        if(parameter is PsiClassType){
            return parameter.resolve()
        }
    }
    return null
}

fun PsiClass.isEntity(): Boolean {
    return Utils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Entity.CLASS_NAME)
}

fun PsiClass.getAllFieldsOfType(): List<PsiField> {
    if(this.isInterface){
        return ClassInheritorsSearch.search(this).findAll().filter { !it.isInterface }
                .flatMap { it.allFields.asList()}
    } else {
        return this.allFields.asList()
    }
}