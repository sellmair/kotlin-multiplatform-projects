pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        val kotlinVersion = "2.1.255-SNAPSHOT"
        kotlin("multiplatform") version kotlinVersion
        id("org.jetbrains.kotlinx.benchmark") version "0.5.0-SNAPSHOT"
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}
