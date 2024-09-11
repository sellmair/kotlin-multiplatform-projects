pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    plugins {
        val kotlinVersion = "2.0.20"
        kotlin("multiplatform") version kotlinVersion
        id("org.jetbrains.kotlinx.benchmark") version "0.4.11"
        id("com.android.library") version "8.5.2"
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}
