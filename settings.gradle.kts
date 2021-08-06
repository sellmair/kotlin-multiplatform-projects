pluginManagement {
    val kotlinVersion = "1.6.255-SNAPSHOT"
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version kotlinVersion
    }

}

rootProject.name = "mpp-issue-bootstrap"
include(":p1")
