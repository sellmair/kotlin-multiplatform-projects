pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.4.255-SNAPSHOT"
        kotlin("android") version "1.4.255-SNAPSHOT"
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

