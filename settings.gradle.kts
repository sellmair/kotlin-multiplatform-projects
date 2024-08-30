pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        val kotlinVersion = "2.0.20"
        kotlin("multiplatform") version kotlinVersion
        id("org.jetbrains.kotlinx.benchmark") version "0.4.11"
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
