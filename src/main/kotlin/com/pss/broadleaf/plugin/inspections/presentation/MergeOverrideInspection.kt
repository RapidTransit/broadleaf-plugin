package com.pss.broadleaf.plugin.inspections.presentation

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.util.xml.converters.values.NumberValueConverter
import com.pss.broadleaf.plugin.PropertyPath
import com.pss.broadleaf.plugin.annotations.AdminPresentationMergeEntryWrapper as ME
import com.pss.broadleaf.plugin.annotations.AdminPresentationMergeOverridesWrapper
import com.pss.broadleaf.plugin.annotations.AnnotationFactory
import org.funktionale.either.Either
import org.jetbrains.uast.java.annotations
import kotlin.reflect.full.declaredFunctions

fun <X> Pair<PsiElement, X>.element(): PsiElement{
    return this.first
}
fun <X> Pair<PsiElement, X>.value(): X{
    return this.second
}

class MergeOverrideInspection {

    companion object {
        val INTEGER_OR_LONG = Regex("^[0-9]+$")
        val DOUBLE_OR_FLOAT = Regex("^[0-9]+(\\.[0-9]+)?$")
        val BOOLEAN = Regex("true|false")

        val INT_INSPECT =  BaseChecker(INTEGER_OR_LONG, Int.javaClass)
        val LONG_INSPECT =  BaseChecker(INTEGER_OR_LONG, Long.javaClass)
        val DOUBLE_INSPECT =  BaseChecker(DOUBLE_OR_FLOAT, Double.javaClass)
        val FLOAT_INSPECT =  BaseChecker(DOUBLE_OR_FLOAT, Float.javaClass)
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
                            registerProblem(holder, name.first, "field.not-annotated")
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
                                                INT_INSPECT.check(holder, override, mergeEntry.intOverrideValue(), mergeEntry)
                                            }
                                            klass == IntArray::class.javaPrimitiveType ->{

                                            }
                                            klass == Long::class.javaPrimitiveType -> {
                                                LONG_INSPECT.check(holder, override, mergeEntry.longOverrideValue(), mergeEntry)
                                            }
                                            klass == LongArray::class.javaPrimitiveType ->{

                                            }
                                            klass == Float::class.javaPrimitiveType -> {
                                                FLOAT_INSPECT.check(holder, override, mergeEntry.floatOverrideValue(), mergeEntry)
                                            }
                                            klass == FloatArray::class.javaPrimitiveType ->{

                                            }
                                            klass == Double::class.javaPrimitiveType ->{
                                                DOUBLE_INSPECT.check(holder, override, mergeEntry.doubleOverrideValue(), mergeEntry)
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
                        registerProblem(holder, name.first, "field.does-not-exist")
                    }
                }
            }
        }
    }


    fun registerProblem(holder: ProblemsHolder, element: PsiElement, message: String){
        holder.registerProblem(element, message)
    }


    class BaseChecker(val regex: Regex, val target: Class<in Number>,  val nullOrEmpty: List<(ME)-> Pair<PsiElement, Any>?> = emptyList()) {

        fun check(holder: ProblemsHolder, x: Pair<PsiElement, String>?, y: Pair<PsiElement, Any>?,  me: ME){
            if((x != null) xor (y != null)){
                if(x != null){
                    val (element, value) = x;
                    if(value.isEmpty()){

                        holder.registerProblem(element, "merge.override.value.blank")
                    } else if(!regex.matches(x.value())){
                        holder.registerProblem(element, "merge.override.value.not-a-number")
                    } else {
                        try {
                            val number = NumberValueConverter.parseNumber(value, target)
                        } catch (e: Exception){
                            holder.registerProblem(element, "merge.override.value.not-a-number")
                        }
                    }
                    //mapValue(holder, me)
                } else if(y != null){
                    val (element, value) = y;
                    //mapValue(holder, me)
                }
            }
        }

        protected fun mapValue(holder: ProblemsHolder, me: ME){
            val mapped = nullOrEmpty.mapNotNull { it(me) }
            if(mapped.isNotEmpty()){
                mapped.forEach {
                    holder.registerProblem(it.first, "")
                }
            }
        }

    }


}