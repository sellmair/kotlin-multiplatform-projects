pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.6.255-SNAPSHOT"
        kotlin("android") version "1.6.255-SNAPSHOT"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                val androidVersion = if(System.getProperty("idea.active") == "true")
                    "4.2.0" else "7.1.0-beta03"
                useModule("com.android.tools.build:gradle:$androidVersion")
            }
        }
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":p1")
include(":p2")

