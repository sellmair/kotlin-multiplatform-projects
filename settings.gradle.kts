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
        kotlin("jvm") version kotlinVersion

        val androidVersion = "8.0.2"
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

include(":consumer")
include(":producer")