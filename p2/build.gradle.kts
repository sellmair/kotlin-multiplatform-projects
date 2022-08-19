@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.plugin.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.hierarchy.createSharedSourceSets

plugins {
    kotlin("multiplatform")
}

/*
Idea #2:
Make it simpler to create shared source sets on a target level.
This approach is more verbose/explicit
 */
kotlin {
    createSharedSourceSets("macos", macosX64(), macosArm64())
    createSharedSourceSets("linux", linuxX64(), linuxArm64())
    createSharedSourceSets("ios", iosX64(), iosArm64(), iosArm32())
    createSharedSourceSets("apple", macosX64(), macosArm64(), iosX64(), iosArm64(), iosArm32())

    createSharedSourceSets(
        "native",
        macosArm64(), macosX64(),
        iosX64(), iosArm64(), iosArm32(),
        linuxX64(), linuxArm64()
    )

    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting

    val nativeMain by sourceSets.getting
    val nativeTest by sourceSets.getting

    val iosMain by sourceSets.getting
    val iosTest by sourceSets.getting

    val appleMain by sourceSets.getting
    val appleTest by sourceSets.getting

    nativeMain.dependsOn(commonMain)
    nativeTest.dependsOn(commonTest)

    appleMain.dependsOn(nativeMain)
    appleTest.dependsOn(nativeTest)

    iosMain.dependsOn(appleMain)
    iosTest.dependsOn(appleTest)
}
