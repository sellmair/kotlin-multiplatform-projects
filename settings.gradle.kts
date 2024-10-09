pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    plugins {
        val kotlinVersion = "2.0.20"
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("android") version kotlinVersion
        id("com.android.library") version "8.5.2"
        id("com.android.application") version "8.5.2"
        id("androidx.benchmark") version "1.3.2"
        id("org.jetbrains.kotlinx.benchmark") version "0.4.12"
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

