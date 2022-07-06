pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
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
                useModule("com.android.tools.build:gradle:7.1.0")
            }
        }
    }

    dependencyResolutionManagement {
        repositories {
            mavenLocal()
            mavenCentral()
            google()
        }
    }
}

include(":androidApp")
include(":jvmLibrary")
include(":multiplatformAndroidApp")
include(":multiplatformAndroidJvmIosLibrary")
include(":multiplatformAndroidJvmIosLibrary2")
include(":multiplatformAndroidLibrary")
include(":multiplatformJvmLibrary")
