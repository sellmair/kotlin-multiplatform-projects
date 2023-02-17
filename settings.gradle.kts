pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    plugins {
        val kotlinVersion = "1.9.255-SNAPSHOT"
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
        id("com.android.application") version "7.3.1"
        id("com.android.library") version "7.3.1"
    }

}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

include(":producer")
include(":consumer")
