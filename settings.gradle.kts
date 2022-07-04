pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
    }
    plugins {
        kotlin("multiplatform") version "1.7.255-SNAPSHOT"
        kotlin("android") version "1.7.255-SNAPSHOT"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.1.0")
            }
        }
    }
}

include(":p1")
include(":p2")
include(":p3")

