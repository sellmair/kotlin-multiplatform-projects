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
    targetHierarchy.default {
        group("native") {
            group("nix") {
                anyLinux()
                anyMacos()
            }
        }

        common {
            group("jvmAndNix") {
                jvm()
                anyLinux()
                anyMacos()
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
