pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.8.255-SNAPSHOT"
        kotlin("jvm") version "1.8.255-SNAPSHOT"
        //kotlin("multiplatform") version "1.7.20-RC"
        //kotlin("android") version "1.8.255-SNAPSHOT"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.2.2")
            }
        }
    }
}

include(":p1")
include(":p2")

