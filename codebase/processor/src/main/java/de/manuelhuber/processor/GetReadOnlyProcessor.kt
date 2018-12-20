package de.manuelhuber.processor

import com.google.auto.service.AutoService
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import de.manuelhuberde.annotations.GetReadOnly
import java.io.File
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.TypeElement
import javax.lang.model.type.DeclaredType
import javax.tools.Diagnostic

@AutoService(Processor::class) // For registering the service
//@SupportedSourceVersion(SourceVersion.RELEASE_8) // to support Java 8
//@SupportedOptions(GetReadOnlyProcessor.KAPT_KOTLIN_GENERATED_OPTION_NAME)
class GetReadOnlyProcessor : AbstractProcessor() {
    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(GetReadOnly::class.java.canonicalName)
    }

    override fun process(p0: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {
        processingEnv.messager.printMessage(javax.tools.Diagnostic.Kind.WARNING, "FOOBAR")
        roundEnv?.getElementsAnnotatedWith(GetReadOnly::class.java)?.forEach { element: Element? ->
            processingEnv.messager.printMessage(javax.tools.Diagnostic.Kind.WARNING, element?.simpleName)
            processingEnv.messager.printMessage(javax.tools.Diagnostic.Kind.WARNING, element?.kind.toString())
            if (element == null || element.kind != ElementKind.FIELD) {
                processingEnv.messager.printMessage(javax.tools.Diagnostic.Kind.ERROR, "${element?.simpleName} is not a field")
                return false
            }
            val packageName = processingEnv.elementUtils.getPackageOf(element).toString()
            generateMethod(element, packageName)
        }
        return false
    }

    private fun generateMethod(element: Element, packageName: String) {
        val generatedSourcesRoot: String = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME].orEmpty()
        processingEnv.messager.printMessage(javax.tools.Diagnostic.Kind.WARNING, generatedSourcesRoot)
        if (generatedSourcesRoot.isEmpty()) {
//            processingEnv.messager.errormessage { "Can't find the target directory for generated Kotlin files." }
            return
        }

        val type = element.asType()
        var genericType = splitName((type as DeclaredType).typeArguments.first().toString())

        val genericDataType = ClassName(genericType.first, genericType.second)
        val liveDataType = ClassName("android.arch.lifecycle", "LiveData")
        val returnType = liveDataType.parameterizedBy(genericDataType)

        val function = FunSpec.builder("foobar")
                .addModifiers(KModifier.PUBLIC)
                .addStatement("return ${element.simpleName}")
                .returns(returnType)
                .build()

        FileSpec.builder(packageName, "GetReadOnlyGenerated").addFunction(function)
                .build().writeTo(File(generatedSourcesRoot))


    }

    private fun print(msg: String) {
        processingEnv.messager.printMessage(Diagnostic.Kind.WARNING, msg)
    }

    private fun splitName(raw: String): Pair<String, String> {
        print("YO")
        print(raw)
        val idx = raw.lastIndexOf(".")
        return Pair(raw.substring(0, idx), raw.substring(idx + 1))
    }

    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
}