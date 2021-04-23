pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.5.255-SNAPSHOT"
        kotlin("android") version "1.5.255-SNAPSHOT"
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
include(":p3")
include(":p4")
include(":p5")