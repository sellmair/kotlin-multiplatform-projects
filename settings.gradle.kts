pluginManagement {
    val kotlinVersion = "1.5.255-SNAPSHOT"
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
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:4.0.2")
            }
        }
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":p1")
include(":p2")
