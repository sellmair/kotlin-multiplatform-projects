pluginManagement {
    val kotlinVersion = "1.8.255-SNAPSHOT"
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
    }
}

rootProject.name = "kotlin-multiplatform-projects"
include(":p1")
include(":p2")
