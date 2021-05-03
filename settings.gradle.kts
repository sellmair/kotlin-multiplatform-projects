pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        //kotlin("multiplatform") version "1.5.0" // <- bad
        //kotlin("multiplatform") version "1.5.255-SNAPSHOT" // <- good
        kotlin("multiplatform") version "1.5.0-RC" // <- good
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":p1")
include(":p2")

