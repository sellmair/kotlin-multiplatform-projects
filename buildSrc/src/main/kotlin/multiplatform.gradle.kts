import org.jetbrains.kotlin.gradle.plugin.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
import org.jetbrains.kotlin.konan.target.Family

plugins {
    kotlin("multiplatform")
}


/*
 Pre-declare hierarchy and targets. Usually one convention plugin would declare the hiearchy, wheras
 another depending convention plugin would declare targets!
 */
@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    hierarchy.natural { target ->
        fun KotlinTarget.isNix(): Boolean = isApple || isLinux

        if (target.isNative) {
            group("native") {
                if (target.isNix()) {
                    group("nix")
                }
            }
        }

        if (target.isNix() || target.isJvm) {
            group("jvmAndNix") {
                if (target.isNix()) {
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
