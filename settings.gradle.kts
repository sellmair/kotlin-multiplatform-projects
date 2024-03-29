pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    plugins {
        val kotlinVersion = "2.0.255-SNAPSHOT"
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion

        val androidVersion = "8.1.2"
        id("com.android.application") version androidVersion
        id("com.android.library") version androidVersion
    }

}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}

include(":p1")
include(":p2")
