import org.jetbrains.kotlin.gradle.android.kpm.android
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.jvm

plugins {
    kotlin("multiplatform.pm20")
    id("com.android.application")
    id("kotlin-android-kpm")
}

android {
    compileSdk = 31
}

kotlin {
    jvm {}
    android()
}
