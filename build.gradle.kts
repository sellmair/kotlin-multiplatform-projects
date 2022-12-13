@file:Suppress("OPT_IN_USAGE")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

repositories {
    mavenLocal()
    mavenCentral()
}

android {
    compileSdk = 33
}

kotlin {
    targetHierarchy.default()
    android()
    linuxX64()
    linuxArm64()
    js(IR)
    ios()
}

