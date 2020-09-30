pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.4.10"
        kotlin("android") version "1.4.10"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:3.6.4")
            }
        }
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":p1")
include(":p2")

