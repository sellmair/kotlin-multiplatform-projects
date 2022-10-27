@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("nix")
}

kotlin {
    targetHierarchy.default {
        common {
            ios()
        }
    }
    jvm()
    linuxX64()
    macosX64()
}
