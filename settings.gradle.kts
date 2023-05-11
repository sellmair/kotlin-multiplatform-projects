pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    plugins {
        val kotlinVersion = "1.8.20"
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("android") version kotlinVersion
    }

}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

include(":multiplatform")
include(":jvm")
