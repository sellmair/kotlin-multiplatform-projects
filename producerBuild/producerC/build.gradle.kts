@file:Suppress("OPT_IN_USAGE")

plugins {
    kotlin("multiplatform")
    `maven-publish`
}


group = "org.jetbrains.sample"
version = "1.0.0-SNAPSHOT"

kotlin {
    targetHierarchy.default()
    jvm()
    linuxX64()
    iosX64()
    iosArm64()

    sourceSets.commonMain.get().dependencies {
        api("com.squareup.okio:okio:3.3.0")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("com.arkivanov.mvikotlin:mvikotlin:3.0.2")
        implementation("com.arkivanov.mvikotlin:mvikotlin-main:3.0.2")
    }
}