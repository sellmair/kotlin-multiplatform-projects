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

include(":p1")
