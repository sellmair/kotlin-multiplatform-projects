pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
    }
    plugins {
        kotlin("multiplatform") version "1.7.0"
        kotlin("jvm") version "1.7.0"
        kotlin("android") version "1.7.0"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.2.1")
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
