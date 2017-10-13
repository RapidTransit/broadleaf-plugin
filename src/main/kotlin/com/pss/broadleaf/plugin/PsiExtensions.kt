package com.pss.broadleaf.plugin

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.psi.*
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.psi.util.InheritanceUtil
import com.intellij.psi.util.PsiTypesUtil
import com.siyeh.ig.psiutils.CollectionUtils
import com.siyeh.ig.psiutils.TypeUtils
import javax.lang.model.element.TypeElement

/**
 * Element Types
 */
fun PsiElement.getField(): PsiField?  = BroadleafPsiUtils.getField(this)



/**
 * PsiFields
 */
fun PsiField.isCollectionType(): Boolean = CollectionUtils.isCollectionClassOrInterface(this.type)


fun PsiField.isSimpleType(): Boolean {
    val type = PsiTypesUtil.getPsiClass(this.type)
    return BroadleafConstants.AcceptableTypes.SIMPLE.contains(type?.qualifiedName)
}

fun PsiField.isMapType(): Boolean = InheritanceUtil.isInheritor(this.type, CommonClassNames.JAVA_UTIL_MAP)


fun PsiField.doWithAnnotation(annotationFQN: Set<String>, function: (PsiField, PsiAnnotation)->Unit){
    val annotation = AnnotationUtil.findAnnotation(this, annotationFQN, true)
    if(annotation != null){
        function(this, annotation)
    }
}

fun PsiField.getJPATargetEntity(): PsiClass? {
    return AnnotationUtil.findAnnotation(this, BroadleafConstants.AcceptableTypes.RELATION)?.let first@ {
         it.findDeclaredAttributeValue(BroadleafConstants.JpaAnnotations.OneToMany.TARGET_ENTITY)?.let {
            if(it is PsiClassObjectAccessExpression){
                return@first PsiTypesUtil.getPsiClass(it.type)
            }
            return@first null
        }
    }
}

fun PsiField.getMappedBy(): String? {
    return AnnotationUtil.findAnnotation(this, BroadleafConstants.AcceptableTypes.RELATION)?.let first@ {
        it.findDeclaredAttributeValue(BroadleafConstants.JpaAnnotations.OneToMany.MAPPED_BY)?.let {
            if(it is PsiLiteralExpression){
                return@first it.value as String
            }
            return@first null
        }
    }
}

fun PsiField.getTargetEntity(): PsiClass? {
    return this.getJPATargetEntity()?: if (this.isCollectionType())  this.getCollectionComponent() else PsiTypesUtil.getPsiClass(this.type)
}

/**
 * If a type element is not found it returns the 'this'
 */
fun PsiField.getTypeElementOrField(index: Int): PsiElement {
    return this.typeElement?.innermostComponentReferenceElement?.parameterList?.typeParameterElements?.get(index)?: this
}



fun PsiField.getAnnotation(annotationFQN: Set<String>): PsiAnnotation? {
    return AnnotationUtil.findAnnotation(this, annotationFQN, true)
}

fun PsiField.isAnnotated(annotationFQN: String): Boolean {
    return AnnotationUtil.isAnnotated(this, annotationFQN, false, true)
}

fun PsiField.isAnnotated(annotationFQN: Set<String>): Boolean {
    return annotationFQN.any { AnnotationUtil.isAnnotated(this, it, false, true) }
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


/**
 * PsiClass
 */
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
        return t.isAssignableFrom(type)
    }
    return false
}


fun PsiClass.isAnnotated(annotationFQN: Set<String>): Boolean {
    return annotationFQN.any { AnnotationUtil.isAnnotated(this, it, false, true) }
}
fun PsiClass.isAnnotated(annotationFQN: String): Boolean {
    return AnnotationUtil.isAnnotated(this, annotationFQN, false, true)
}

fun PsiClass.findAllConcreteTypes(): Collection<PsiClass> {
    return ClassInheritorsSearch.search(this, true).findAll().filter { !it.isInterface }
}

fun PsiClass.getFields(name: String): Collection<PsiField> {
    return this.findAllConcreteTypes().flatMap { it.fields.asList() }.filter { it.name == name }
}
fun PsiClass.isEntity(): Boolean {
    return BroadleafPsiUtils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Entity.CLASS_NAME)
}

fun PsiClass.getAllFieldsOfType(): List<PsiField> {
    if(this.isInterface){
        return ClassInheritorsSearch.search(this).findAll().filter { !it.isInterface }
                .flatMap { it.allFields.asList()}
    } else {
        return this.allFields.asList()
    }
}

/**
 * PsiType
 */
fun PsiType.isManaged(): Boolean {
    return BroadleafPsiUtils.containsAnnotation(this, BroadleafConstants.AcceptableTypes.MANAGED_TYPES)
}

fun PsiType.isEntity(): Boolean {
    return BroadleafPsiUtils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Entity.CLASS_NAME)
}

fun PsiType.isEmbeddable(): Boolean {
    return BroadleafPsiUtils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Embeddable.CLASS_NAME)
}

fun PsiType.isArray(): Boolean {
    return  this is PsiArrayType
}

fun PsiType.findAllConcreteTypes(): Collection<PsiClass> {
    val clazz = PsiTypesUtil.getPsiClass(this)
    if(clazz != null) {
        return ClassInheritorsSearch.search(clazz, true).findAll().filter { !it.isInterface }
    }
    return emptySet()
}


fun PsiType.getFields(name: String): Collection<PsiField> {
    return this.findAllConcreteTypes().flatMap { it.fields.asList() }.filter { it.name == name }
}


