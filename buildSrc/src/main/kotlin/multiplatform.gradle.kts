
import org.jetbrains.kotlin.gradle.plugin.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.targets.jvm.KotlinJvmTarget
import org.jetbrains.kotlin.konan.target.Family

plugins {
    kotlin("multiplatform")
}

val KotlinTarget.isNix: Boolean
    get() = if (this !is KotlinNativeTarget) false
    else konanTarget.family.isAppleFamily || konanTarget.family == Family.LINUX

/*
 Pre-declare hierarchy and targets. Usually one convention plugin would declare the hiearchy, wheras
 another depending convention plugin would declare targets!
 */
kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    hierarchy.natural { target ->
        if (target is KotlinNativeTarget) {
            group("native") {
                if (target.isNix) {
                    group("nix")
                }
            }
        }

        if (target.isNix || target is KotlinJvmTarget) {
            group("jvmAndNix") {
                if (target.isNix) {
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
}