pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("jvm") version "1.7.20-Beta"
    }
}

rootProject.name = "sample"

//include(":library") <- for publishing only
include(":app")

