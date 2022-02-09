pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
    }
    plugins {
        kotlin("multiplatform") version "1.6.255-SNAPSHOT"
        kotlin("jvm") version "1.6.255-SNAPSHOT"
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":p1")
include(":p2")
include(":p3")
