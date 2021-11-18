import org.jetbrains.kotlin.gradle.android.kpm.android
import org.jetbrains.kotlin.gradle.android.kpm.androidCommon
import org.jetbrains.kotlin.gradle.android.kpm.instrumentedTest
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.jvm

plugins {
    kotlin("multiplatform.pm20")
    id("com.android.application")
    id("kotlin-android-kpm")
}

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 30
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

kotlin {
    jvm {}
    android()

    main {
        androidCommon.dependencies {
            implementation(kotlin("stdlib-jdk8"))
            implementation("androidx.appcompat:appcompat:1.3.1")
        }
    }

    test {
        androidCommon.dependencies {
            implementation(kotlin("test-junit"))
            implementation("androidx.test:core:1.4.0")
            implementation("androidx.test:core-ktx:1.4.0")
            implementation("androidx.test.ext:junit:1.1.3")
            implementation("androidx.test.ext:junit-ktx:1.1.3")
        }
    }

    instrumentedTest {
        androidCommon.dependencies {
            implementation(kotlin("test-junit"))
            implementation("androidx.test:core:1.4.0")
            implementation("androidx.test:core-ktx:1.4.0")
            implementation("androidx.test:rules:1.4.0")
        }
    }

}

tasks.register("debug") {
    doLast {
        val task = tasks.getByName("compileTestKotlinAndroidDebugUnitTest")
        logger.quiet("Task class: ${task.javaClass.canonicalName}")
    }
}
