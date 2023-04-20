pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    plugins {
        kotlin("jvm") version "1.9.255-SNAPSHOT"
        kotlin("android") version "1.9.255-SNAPSHOT"
        id("com.android.application") version "7.3.1"
        id("com.android.library") version "7.3.1"
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
