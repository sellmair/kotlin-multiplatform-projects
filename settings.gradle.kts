pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version "1.8.255-SNAPSHOT"
        kotlin("android") version "1.8.255-SNAPSHOT"
        id("com.android.application") version "7.3.1"
        id("com.android.library") version "7.3.1"
    }

}

include(":p1")
include(":p2")
