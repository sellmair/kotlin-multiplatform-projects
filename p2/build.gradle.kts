import org.gradle.api.attributes.Usage.USAGE_ATTRIBUTE
import org.jetbrains.kotlin.compilerRunner.konanHome
import org.jetbrains.kotlin.gradle.cinterop.CommonizerSelectionTransformation
import org.jetbrains.kotlin.gradle.cinterop.CommonizerTransformation
import org.jetbrains.kotlin.gradle.cinterop.CommonizerUsages
import org.jetbrains.kotlin.gradle.cinterop.usage
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinUsages
import org.jetbrains.kotlin.konan.target.KonanTarget

plugins {
    kotlin("multiplatform")
}



kotlin {
    val macos = macosX64("macos")
    val linux = linuxX64("linux")

    /*
    val commonizeCurl = tasks.create<DependencyCommonizerTask>("commonizeCurl") {
        addLibrary(macos, files("libs/macos_x64/curl.klib"))
        addLibrary(linux, files("libs/linux_x64/curl.klib"))
    }
     */

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
    }

    macosMain.dependencies {
        //implementation(files("libs/macos_x64/curl.klib"))
    }

    linuxMain.dependencies {
    }

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }
}

//enableCommonization(setOf(MACOS_X64, LINUX_X64, IOS_ARM32))


val curlKotlinInteropBundle by configurations.creating {
    outgoing {
        attributes {
            attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.interopBundle))
            attribute(KotlinNativeTarget.konanTargetAttribute, "commonizer")
            attribute(KotlinPlatformType.attribute, KotlinPlatformType.common)
        }
    }
    isCanBeResolved = false
    isCanBeConsumed = true
}

artifacts {
    add("curlKotlinInteropBundle", file("libs"))
}

dependencies {
    registerTransform(CommonizerTransformation::class) {
        from.attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.interopBundle))
        from.attribute(KotlinNativeTarget.konanTargetAttribute, "commonizer")

        to.attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.commonizerOutput))
        to.attribute(KotlinNativeTarget.konanTargetAttribute, "commonizer")

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

    for ((_, target) in KonanTarget.predefinedTargets) {
        registerTransform(CommonizerSelectionTransformation::class.java) {
            from.attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.commonizerOutput))
            from.attribute(KotlinNativeTarget.konanTargetAttribute, "commonizer")
            from.attribute(KotlinPlatformType.attribute, KotlinPlatformType.common)

            to.attribute(USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_API))
            to.attribute(KotlinPlatformType.attribute, KotlinPlatformType.native)
            to.attribute(KotlinNativeTarget.konanTargetAttribute, target.name)
            parameters {
                targets = setOf(target)
            }
        }
    }

    registerTransform(CommonizerSelectionTransformation::class.java) {
        from.attribute(USAGE_ATTRIBUTE, project.usage(CommonizerUsages.commonizerOutput))
        to.attribute(USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_METADATA))
        parameters {
            targets = setOf(KonanTarget.MACOS_X64, KonanTarget.LINUX_X64)
        }
    }
}

dependencies {
    "nativeMainImplementation"(project(project.path, curlKotlinInteropBundle.name))
}
