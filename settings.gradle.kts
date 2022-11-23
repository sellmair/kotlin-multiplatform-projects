pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    plugins {
        kotlin("multiplatform") version "1.8.255-SNAPSHOT"
        //kotlin("multiplatform") version "1.6.20"
    }
}

include(":producer")
include(":consumer")
