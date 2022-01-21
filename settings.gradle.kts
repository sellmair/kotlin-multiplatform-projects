pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.6.255-SNAPSHOT"
        kotlin("multiplatform.pm20") version "1.6.255-SNAPSHOT"
        kotlin("android") version "1.6.255-SNAPSHOT"
        id("kotlin-kpm-android") version "1.6.255-SNAPSHOT"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.0.0")
                //useModule("com.android.tools.build:gradle:4.2.0")
            }
        }
    }
}

rootProject.name = "mpp-issue-bootstrap"
//include(":multiplatform")
include(":kpm")
include(":android-consumer")

