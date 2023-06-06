@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.kotlin.gradle.plugin.dependencies
import org.jetbrains.kotlin.gradle.plugin.nativeMain

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}