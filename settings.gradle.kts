pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("jvm") version "1.6.255-SNAPSHOT"
        kotlin("multiplatform") version "1.6.255-SNAPSHOT"
    }
}

include(":p1")
include(":p2")

