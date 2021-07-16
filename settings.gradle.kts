pluginManagement {
    val kotlinVersion = "1.5.255-SNAPSHOT"
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }

    plugins {
        kotlin("multiplatform") version kotlinVersion
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":p1")
include(":p2")
