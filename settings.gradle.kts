pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    plugins {
        kotlin("multiplatform") version "1.8.255-SNAPSHOT"
        kotlin("jvm") version "1.8.255-SNAPSHOT"
        kotlin("android") version "1.8.255-SNAPSHOT"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.3.1")
            }
        }
    }
}

