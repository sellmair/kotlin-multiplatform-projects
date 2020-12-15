import org.gradle.api.attributes.Usage.USAGE_ATTRIBUTE
import org.jetbrains.kotlin.commonizer.api.CommonizerTarget
import org.jetbrains.kotlin.compilerRunner.konanHome
import org.jetbrains.kotlin.gradle.cinterop.CommonizerSelectionTransformation
import org.jetbrains.kotlin.gradle.cinterop.CommonizerTransformation
import org.jetbrains.kotlin.gradle.cinterop.CommonizerUsages
import org.jetbrains.kotlin.gradle.cinterop.usage
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinUsages
import org.jetbrains.kotlin.gradle.tasks.KotlinNativeCompile
import org.jetbrains.kotlin.konan.target.KonanTarget

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
        //implementation(project(":p1"))
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

val artifactType = Attribute.of("artifactType", String::class.java)

dependencies {
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
        registerTransform(CommonizerSelectionTransformation::class.java) {
            from.attribute(USAGE_ATTRIBUTE, rootProject.usage(CommonizerUsages.commonizerOutput))
            from.attribute(KotlinNativeTarget.konanTargetAttribute, "commonizer")

            to.attribute(USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_API))
            to.attribute(KotlinNativeTarget.konanTargetAttribute, konanTarget.name)
            parameters {
                target = CommonizerTarget(konanTarget)
            }
        }
    }

    registerTransform(CommonizerSelectionTransformation::class.java) {
        from.attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.commonizerOutput))
        to.attribute(USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_API))
        parameters {
            target = CommonizerTarget(KonanTarget.MACOS_X64, KonanTarget.LINUX_X64)
        }
    }
}

dependencies {
    "nativeMainImplementation"(project(":p1"))
}

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
