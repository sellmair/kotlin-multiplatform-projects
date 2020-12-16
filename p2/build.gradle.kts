import org.gradle.api.attributes.Usage.USAGE_ATTRIBUTE
import org.jetbrains.kotlin.commonizer.api.CommonizerTarget
import org.jetbrains.kotlin.commonizer.api.LeafCommonizerTarget
import org.jetbrains.kotlin.commonizer.api.identityString
import org.jetbrains.kotlin.compilerRunner.konanHome
import org.jetbrains.kotlin.gradle.ib.*
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinUsages
import org.jetbrains.kotlin.konan.target.KonanTarget
import org.jetbrains.kotlin.konan.target.KonanTarget.*

plugins {
    kotlin("multiplatform")
}


//region Project Structure

kotlin {
    val macos = macosX64("macos")
    val linux = linuxX64("linux")

    val commonMain = sourceSets.getByName("commonMain")
    val nativeMain = sourceSets.create("nativeMain")
    val macosMain = sourceSets.getByName("macosMain")
    val linuxMain = sourceSets.getByName("linuxMain")

    nativeMain.dependsOn(commonMain)
    macosMain.dependsOn(nativeMain)
    linuxMain.dependsOn(nativeMain)

    commonMain.dependencies {
        implementation(kotlin("stdlib-common"))
    }

    nativeMain.dependencies {
        implementation(project(":p1"))
    }

    macosMain.dependencies {
    }

    linuxMain.dependencies {
    }

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }
}

//endregion

//region Enable commonization

/*
val commonizerTarget = Attribute.of("commonizerTarget", String::class.java)
afterEvaluate {
    val allNativeMainConfigurations = configurations.filter {
        it.name.contains("nativeMain", true) /*|| it.name.contains("metadata", true)*/
    }
    val allOtherConfigurations = configurations.filter {
        it !in allNativeMainConfigurations
    }
    allNativeMainConfigurations.forEach { configuration ->
        println("Adding to ${configuration.name}")
        configuration.attributes {
            attribute(commonizerTarget, CommonizerTarget(LINUX_X64, MACOS_X64).identityString)
        }
    }

    allOtherConfigurations.forEach {
        //it.attributes.attribute(commonizerTarget, "*none*")
    }
}

 */

/*
abstract class EmptyTransformation: TransformAction<TransformParameters.None> {
    override fun transform(outputs: TransformOutputs) {
    }
}

dependencies {
    attributesSchema {
        attribute(commonizerTarget)
    }
    registerTransform(CommonizerTransformation::class) {
        from.attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.interopBundle))
        to.attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.commonizerOutput))
        parameters {
            konanHome = File(project.konanHome).absoluteFile
            afterEvaluate {
                commonizerClasspath = configurations.getByName("kotlinKlibCommonizerClasspath").resolve()
            }
            kotlin.targets.withType<KotlinNativeTarget>().all {
                targets = targets + konanTarget
            }
        }
    }

    for ((_, konanTarget) in KonanTarget.predefinedTargets) {
        registerTransform(PlatformInteropKlibSelectionTransformation::class) {
            from.attribute(USAGE_ATTRIBUTE, rootProject.usage(CommonizerUsages.interopBundle))
            from.attribute(KotlinNativeTarget.konanTargetAttribute, "commonizer")

            to.attribute(USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_API))
            to.attribute(KotlinNativeTarget.konanTargetAttribute, konanTarget.name)

            parameters {
                target = LeafCommonizerTarget(konanTarget)
            }
        }
    }

    registerTransform(CommonizerSelectionTransformation::class.java) {
        from.attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.commonizerOutput))
        from.attribute(KotlinPlatformType.attribute, KotlinPlatformType.native)
        from.attribute(commonizerTarget, "*")

        to.attribute(USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_METADATA))
        to.attribute(KotlinPlatformType.attribute, KotlinPlatformType.common)
        to.attribute(commonizerTarget, CommonizerTarget(LINUX_X64, MACOS_X64).identityString)

        parameters {
            target = CommonizerTarget(MACOS_X64, LINUX_X64)
        }
    }

    /*
for ((_, konanTarget) in KonanTarget.predefinedTargets) {
    registerTransform(CommonizerSelectionTransformation::class.java) {
        from.attribute(USAGE_ATTRIBUTE, rootProject.usage(CommonizerUsages.commonizerOutput))
        from.attribute(KotlinPlatformType.attribute, KotlinPlatformType.common)
        from.attribute(KotlinNativeTarget.konanTargetAttribute, "commonizer")

        to.attribute(USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_API))
        to.attribute(KotlinPlatformType.attribute, KotlinPlatformType.native)
        to.attribute(KotlinNativeTarget.konanTargetAttribute, konanTarget.name)
        parameters {
            target = CommonizerTarget(konanTarget)
        }
    }
}

}
 */

/*dependencies {
    "nativeMainImplementation"(project(":p1"))
}*/

//endregion

//region Debugging


/*
val nativeMainImplementation by configurations.getting
val macosMainImplementation by configurations.getting

macosMainImplementation.extendsFrom(nativeMainImplementation)
afterEvaluate {
    println("nativeMain dependencies ${nativeMainImplementation.dependencies.toSet()}")
    println("macosMain dependencies ${macosMainImplementation.dependencies.toSet()}")
}


tasks.getByName("compileKotlinMacos") {
    val compile = this as KotlinNativeCompile
    doFirst {
        println("commonSources: ${compile.commonSources.files}")
        println("libraries: ${compile.libraries.files}")
    }
}
 */
//endregion
