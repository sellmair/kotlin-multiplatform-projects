@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.plugin.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.hierarchy.withNaturalHierarchy

plugins {
    kotlin("multiplatform")
}

/*
Idea #1:
We know that there is some 'natural' hierarchy in targets
(like grouping by 'native', 'apple', 'ios', ...)
All targets declared in this 'withNaturalHierarchy' block will
be setup according to this hierarchy!
 */
kotlin {
    withNaturalHierarchy {
        linuxX64()
        linuxArm64()
        macosX64()
        macosArm64()
        iosArm32()
        iosArm64()
        iosX64()
    }
}
