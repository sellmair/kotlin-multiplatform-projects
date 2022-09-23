import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
import org.jetbrains.kotlin.konan.target.Family

plugins {
    id("multiplatform")
}


/*
 Pre-declare hierarchy and targets. Usually one convention plugin would declare the hiearchy, wheras
 another depending convention plugin would declare targets!
 */
@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targets.hierarchy.custom {
        val isNix: Boolean = isApple || isLinux

        if (isNative) {
            group("native") {
                if (isNix) {
                    group("nix")
                }
            }
        }

        if (isNix || isJvm) {
            group("jvmAndNix") {
                if (isNix) {
                    group("nix")
                }
            }
        }
    }

    /* Declare my targets */
    linuxX64()
    macosX64()
    macosArm64()
    iosX64()
    iosArm64()
    jvm()
}
