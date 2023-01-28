pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.8.0"
        kotlin("android") version "1.8.0"
        id("com.android.application") version "7.3.1"
        id("com.android.library") version "7.3.1"
    }

}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(":p1")
