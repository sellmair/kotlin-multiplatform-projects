pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    plugins {
        //val kotlinVersion = "1.8.20-RC"
        val kotlinVersion = "1.9.255-SNAPSHOT"
        //val kotlinVersion = "1.9.255-master-SNAPSHOT"
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion
        id("com.android.application") version "7.4.2"
        id("com.android.library") version "7.4.2"
    }

}

dependencyResolutionManagement {
    repositories {
        maven(rootProject.projectDir.resolve("build").resolve("repo"))
        mavenLocal()
        mavenCentral()
        google()
    }
}

include(":p1")
include(":p2")
include(":consumer")