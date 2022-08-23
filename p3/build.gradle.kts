@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.plugin.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.hierarchy.createSharedSourceSets
import org.jetbrains.kotlin.gradle.plugin.mpp.hierarchy.withHierarchy

plugins {
    kotlin("multiplatform")
}

/*
Idea #23
 */
kotlin {
    withHierarchy {
        shared("native") {
            shared("nix") {
                shared("apple") {
                    shared("ios") {
                        iosX64()
                        iosArm64()
                        iosSimulatorArm64()
                    }
                    shared("tvos") {
                        tvosArm64()
                        tvosX64()
                    }
                    shared("watchos") {
                        watchosArm32()
                        watchosArm64()
                    }
                    shared("macos") {
                        macosArm64()
                        macosX64()
                    }
                }
            }
            shared("linux") {
                linuxX64()
                linuxArm64()
            }
        }
        shared("windows") {
            mingwX86()
            mingwX64()
        }

        shared("native32") {
            linuxX64()
            linuxArm64()
        }
    }
}
