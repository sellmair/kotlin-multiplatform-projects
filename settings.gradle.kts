pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
        jcenter()

    }
    plugins {
        kotlin("multiplatform") version "1.4.20"
        kotlin("plugin.serialization") version "1.4.20"
        kotlin("android") version "1.4.20"
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

