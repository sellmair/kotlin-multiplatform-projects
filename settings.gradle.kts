pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    plugins {
        var kotlinVersion = "1.9.255-SNAPSHOT"
        kotlinVersion = "1.9.20-Beta"
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
//include(":p2")
