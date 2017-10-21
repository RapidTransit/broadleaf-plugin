package com.pss.broadleaf.plugin

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.openapi.util.Condition
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.*
import com.intellij.psi.impl.PsiManagerEx
import com.intellij.psi.search.searches.ClassInheritorsSearch
import com.intellij.psi.util.*
import com.siyeh.ig.psiutils.CollectionUtils
import com.siyeh.ig.psiutils.TypeUtils

import org.jetbrains.uast.getUastParentOfType
import javax.lang.model.element.TypeElement
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationClass
import com.pss.broadleaf.plugin.BroadleafPsiUtils.findConcrete
import com.pss.broadleaf.plugin.BroadleafConstants.PresentationAnnotations.AdminPresentationAdornedTargetCollection as Adorned
import org.jetbrains.uast.java.annotations



/**
 * Element Types
 */
fun PsiElement.getField(): PsiField?  = BroadleafPsiUtils.getField(this)


val isCollectionType = Key<Boolean>("isCollectionType")
/**
 * PsiFields
 */
fun PsiField.isCollectionType(): Boolean {
    return this.cacheGet(com.pss.broadleaf.plugin.isCollectionType, {InheritanceUtil.isInheritor(this.type, CommonClassNames.JAVA_UTIL_COLLECTION)})
}


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
val getJPATargetEntity = Key<PsiClass?>("getJPATargetEntity")
fun PsiField.getJPATargetEntity(): PsiClass? {
    return this.cacheGet(getJPATargetEntity, {
        return AnnotationUtil.findAnnotation(this, BroadleafConstants.AcceptableTypes.RELATION)?.let first@ {
            it.findDeclaredAttributeValue(BroadleafConstants.JpaAnnotations.OneToMany.TARGET_ENTITY)?.let {
                if (it is PsiClassObjectAccessExpression) {
                    return@first PsiTypesUtil.getPsiClass(it.type)
                }
                return@first null
            }
        }
    })
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


val getAdornedPsiClasses = Key<List<PsiClass>>("getAdornedPsiClasses")
fun PsiField.getAdornedPsiClasses(): List<PsiClass> {
    return this.cacheGet(getAdornedPsiClasses, {
        val list = mutableListOf<PsiClass>()
        this.getCollectionComponent()?.let {
            val concrete = BroadleafPsiUtils.findConcrete(it)
            list.addAll(concrete)
            this.doWithAnnotation(Adorned.CLASS_NAME_SET, { field, annotation ->
                AnnotationUtil.getStringAttributeValue(annotation, Adorned.TARGET_OBJECT_PROPERTY)?.let { value ->
                    concrete.mapNotNull { it.findFieldByName(value, true) }.map { it.type }.filterIsInstance(PsiClassType::class.java)
                            .mapNotNull { it.resolve() }.flatMap { findConcrete(it) }.toCollection(list)
                }
            })
        }
        return list
    })
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

fun PsiField.getClassTypeOrComponentClassType(): PsiClass? {
    return if (this.isCollectionType())  this.getCollectionComponent() else PsiTypesUtil.getPsiClass(this.type)
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

val isPopulateToOne = Key<Boolean>("isPopulateToOne")
fun PsiClass.isPopulateToOne(): Boolean {
    return this.cacheGet(isPopulateToOne, {
    return AnnotationUtil.findAnnotation(this, AdminPresentationClass.CLASS_NAME_SET)?.findDeclaredAttributeValue(AdminPresentationClass.POPULATE_TO_ONE_FIELDS)?.let {
        if(it is PsiReferenceExpression ){
            it.referenceName?.let {
                if(it == BroadleafConstants.EnumTypes.PopulateToOneFieldsEnum.TRUE){
                    return true
                }
            }
        }
        return false
    }?: false})
}

fun PsiClass.isAnnotated(annotationFQN: Set<String>): Boolean {
    return annotationFQN.any { AnnotationUtil.isAnnotated(this, it, false, true) }
}
fun PsiClass.isAnnotated(annotationFQN: String): Boolean {
    return AnnotationUtil.isAnnotated(this, annotationFQN, false, true)
}
val findAllConcreteTypes = Key<Collection<PsiClass>>("findAllConcreteTypes")
fun PsiClass.findAllConcreteTypes(): Collection<PsiClass> {
    return this.cacheGet(findAllConcreteTypes, {
        return ClassInheritorsSearch.search(this, true).findAll().filter { !it.isInterface }
    })
}

fun PsiClass.findAllConcreteTypesWithThis(): Collection<PsiClass> {
    val concrete = this.cacheGet(findAllConcreteTypes, {
        return ClassInheritorsSearch.search(this, true).findAll().filter { !it.isInterface }
    })
    if(!this.isInterface){
        val mutable = concrete.toMutableList()
        mutable.add(this)
        return mutable
    }
    return concrete
}


fun PsiClass.getFields(name: String): Collection<PsiField> {
    return this.findAllConcreteTypesWithThis().flatMap { it.fields.asList() }.filter { it.name == name }
}
fun PsiClass.isEntity(): Boolean {
    return BroadleafPsiUtils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Entity.CLASS_NAME)
}

val getInheritorsWithThis = Key<MutableCollection<PsiClass>>("getInheritorsWithThis")
fun PsiClass.getInheritorsWithThis(): MutableCollection<PsiClass> {
    return this.cacheGet(com.pss.broadleaf.plugin.getInheritorsWithThis, {
        val result = ClassInheritorsSearch.search(this).findAll()
        result.add(this)
        return result
    })
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
val isManaged = Key<Boolean>("isManaged")
fun PsiType.isManaged(): Boolean {
    return BroadleafPsiUtils.containsAnnotation(this, BroadleafConstants.AcceptableTypes.MANAGED_TYPES)
}
val isEntity = Key<Boolean>("isEntity")
fun PsiType.isEntity(): Boolean {
    return BroadleafPsiUtils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Entity.CLASS_NAME)
}
val isEmbeddable = Key<Boolean>("isEmbeddable")
fun PsiType.isEmbeddable(): Boolean {
    return BroadleafPsiUtils.containsAnnotation(this, BroadleafConstants.JpaAnnotations.Embeddable.CLASS_NAME)
}

fun PsiType.isArray(): Boolean {
    return  this is PsiArrayType
}
val concreteTypes = Key<Collection<PsiClass>>("concreteTypes")
fun PsiType.findAllConcreteTypes(): Collection<PsiClass> {
    val clazz = PsiTypesUtil.getPsiClass(this)
    if(clazz != null) {
        return clazz.cacheGet(concreteTypes, {
            return ClassInheritorsSearch.search(clazz, true).findAll().filter { !it.isInterface }
        })
    }
    return emptySet()
}


fun PsiType.getFields(name: String): Collection<PsiField> {
    return this.findAllConcreteTypes().flatMap { it.fields.asList() }.filter { it.name == name }
}


fun <T:  PsiElement>PsiElement.findParent(type: Class<out T>): T? {
    return PsiTreeUtil.getParentOfType(this, type)
}

fun PsiElement.javaPsiFacade(): JavaPsiFacade {
    return JavaPsiFacade.getInstance(this.project)
}

fun PsiElement.findParent(filter: Condition<PsiElement>): PsiElement? {
    return PsiTreeUtil.findFirstParent(this, filter)
}




fun List<PsiClass>.reduceFields(field: String): MutableList<PsiClass>{
    return this.mapNotNull { it.findFieldByName(field, true) }
            .filter { it.type is PsiClassType }
            .mapNotNull { (it.type as PsiClassType).resolve() }
            .flatMap { findConcrete(it) }
            .toMutableList()
}

inline fun <T> PsiLiteralExpression.supplyValueIsString(func: (String) -> T): T? {
    val value = this.value
    if(value is String){
        return func(value)
    }
    return null
}

inline fun <T> PsiLiteralExpression.valueIsString(func: (String) -> T, def: T): T {
    val value = this.value
    if(value is String){
        return func(value)
    }
    return def
}

inline fun  PsiLiteralExpression.valueIsString(func: (String) -> Unit) {
    val value = this.value
    if(value is String){
        func(value)
    }
}
inline fun <T> PsiElement.cacheGet(key: Key<T>, func: ()->T): T {
    val cache = this.getUserData(key)
    if(cache != null){
        return cache
    } else {
        val value = func()
        this.putUserData(key, value)
        return value
    }

}

fun <T> Array<out T>.second(): T {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[1]
}