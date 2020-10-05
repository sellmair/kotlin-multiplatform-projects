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

rootProject.name = "mpp-issue-child"
include(":p1")
project(":p1").projectDir = file("../p1")


