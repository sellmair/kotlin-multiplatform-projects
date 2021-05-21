import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinNativeTargetPreset

plugins {
    kotlin("multiplatform")
}

kotlin {
    presets.forEach { preset ->
        if (preset is AbstractKotlinNativeTargetPreset) {
            targetFromPreset(preset)
        }
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}
