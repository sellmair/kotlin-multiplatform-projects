import org.jetbrains.kotlin.gradle.android.android
import org.jetbrains.kotlin.gradle.android.androidCommon
import org.jetbrains.kotlin.gradle.android.instrumentedTest
import org.jetbrains.kotlin.gradle.kpm.external.compilationData
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.KotlinIosX64Variant
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.KotlinLinuxX64Variant
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.jvm

plugins {
    kotlin("multiplatform.pm20")
    //id("com.android.application")
    id("com.android.library")
    id("kotlin-kpm-android")
    `maven-publish`
}

group = "kpm-android-external"
version = "1.0"

publishing {
    repositories {
        maven(buildDir.resolve("repo")) {
            name = "buildRepo"
        }
    }
}

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 30
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("debug")
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

// TODO NOW
tasks.matching { it.name.matches(Regex("""compile.*Android.*Metadata""")) }.configureEach {
    enabled = false
}

kotlin {
    android()
    jvm {}

    mainAndTest {
        fragments.create<KotlinIosX64Variant>("iosX64")
    }
}


