package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.pss.broadleaf.plugin.PropertyPath
import com.pss.broadleaf.plugin.annotations.AdminPresentationMergeOverrideWrapper
import com.pss.broadleaf.plugin.annotations.AdminPresentationMergeOverridesWrapper
import com.pss.broadleaf.plugin.annotations.AnnotationFactory
import com.pss.broadleaf.plugin.reference.PropertyPathReference
import org.funktionale.either.Either
import org.jetbrains.uast.java.annotations
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.functions

class MergeOverrideInspection {

    companion object {
        val INTEGER_OR_LONG = Regex("^[0-9]+$")
        val DOUBLE_OR_FLOAT = Regex("^[0-9]+(\\.[0-9]+)?$")
        val BOOLEAN = Regex("true|false")
    }

    fun inspectClass(psiClass: PsiClass, holder: ProblemsHolder){
        AnnotationUtil.findAnnotation(psiClass, AdminPresentationMergeOverridesWrapper.CLASS_NAME)?.let { psiAnnotation ->
            val annotationWrapper = AdminPresentationMergeOverridesWrapper(psiAnnotation)
            annotationWrapper.value().forEach { mergeOverride ->
                val name = mergeOverride.name()
                if(name != null && name.second.isNotEmpty()){
                    val path = PropertyPath(psiClass, name.second)
                    if(path.isResolved()){
                        val resolvedPath = path.resolve()
                        val resolvedAnnotations = resolvedPath.fields.flatMap { it.annotations.asList() }.filter { AnnotationFactory.getFactory().containsKey(it.qualifiedName) }
                        if(resolvedAnnotations.isEmpty()){
                            // not annotated
                        } else {
                            val resolvedWrappers = resolvedAnnotations.mapNotNull{AnnotationFactory.getFactory().get(it.qualifiedName)?.invoke(it)}
                            mergeOverride.mergeEntries().forEach { mergeEntry ->
                                mergeEntry.propertyType()?.let { pair ->
                                    val wrapper = resolvedWrappers.firstOrNull { it.getMethods().containsKey(pair.second) }
                                    if(wrapper != null){
                                        val typeMap =  wrapper::class.declaredFunctions.associateBy{ it.name }
                                        val klass = wrapper.getMethods().get(pair.second)
                                        val override = mergeEntry.overrideValue()
                                        when{
                                            klass == Int::class.javaPrimitiveType -> {
                                                xor(override, mergeEntry.intOverrideValue(), { x->
                                                    if(x.second.isBlank()){
                                                        // Is Blank
                                                    } else {
                                                        if(!INTEGER_OR_LONG.matches(x.second)){
                                                            // Is Not An Integral
                                                        }
                                                    }
                                                }, { y->
                                                    if(y.second == Int.MIN_VALUE){
                                                        // Is Def
                                                    }
                                                })
                                            }
                                            klass == IntArray::class.javaPrimitiveType ->{

                                            }
                                            klass == Long::class.javaPrimitiveType -> {
                                                xor(override, mergeEntry.longOverrideValue(), { x->
                                                    if(x.second.isBlank()){
                                                        // Is Blank
                                                    } else {
                                                        if(!INTEGER_OR_LONG.matches(x.second)){
                                                            // Is Not An Integral
                                                        }
                                                    }
                                                }, { y->
                                                    if(y.second == Long.MIN_VALUE){
                                                        // Is Def
                                                    }
                                                })
                                            }
                                            klass == LongArray::class.javaPrimitiveType ->{

                                            }
                                            klass == Float::class.javaPrimitiveType -> {
                                                xor(override, mergeEntry.floatOverrideValue(), { x->
                                                    if(x.second.isBlank()){
                                                        // Is Blank
                                                    } else {
                                                        if(!DOUBLE_OR_FLOAT.matches(x.second)){
                                                            // Is Not An Integral
                                                        }
                                                    }
                                                }, { y->
                                                    if(y.second == Float.MIN_VALUE){
                                                        // Is Def
                                                    }
                                                })
                                            }
                                            klass == FloatArray::class.javaPrimitiveType ->{

                                            }
                                            klass == Double::class.javaPrimitiveType ->{
                                                xor(override, mergeEntry.doubleOverrideValue(), { x->
                                                    if(x.second.isBlank()){
                                                        // Is Blank
                                                    } else {
                                                        if(!DOUBLE_OR_FLOAT.matches(x.second)){
                                                            // Is Not An Integral
                                                        }
                                                    }
                                                }, { y->
                                                    if(y.second == Double.MIN_VALUE){
                                                        // Is Def
                                                    }
                                                })
                                            }
                                            klass == DoubleArray::class.javaPrimitiveType ->{

                                            }
                                            klass == Enum::class.java ->{

                                            }
                                            (klass?.isArray == true && klass.componentType.isEnum)->{

                                            }
                                            klass == Annotation::class.java ->{

                                            }
                                            (klass?.isArray == true && klass.componentType.isAnnotation)->{

                                            }
                                        }
                                    } else {
                                        // Doesn't Exist
                                    }
                                }

                            }
                        }
                    } else {
                        // Not Found
                    }
                }
            }
        }
    }

    fun <X, Y>xor(x : X?, y: Y?, xfunc: (x: X)-> Unit, yfunc:(y:Y)->Unit){
        if((x != null) xor (y != null)){
            if(x != null){
                xfunc(x)
            } else if(y != null) {
                yfunc(y)
            }
        } else {

        }

    }
}