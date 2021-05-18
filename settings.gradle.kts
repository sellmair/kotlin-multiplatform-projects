pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.5.255-SNAPSHOT"
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":p1")

