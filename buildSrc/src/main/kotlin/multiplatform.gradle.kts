import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
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
    targets.hierarchy.default()

    /* Declare my targets */
    ios()
    linuxX64()
    macosX64()
    macosArm64()
    iosX64()
    iosArm64()
    jvm()
}
