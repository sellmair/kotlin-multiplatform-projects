pluginManagement {
    repositories {
        maven("https://repo.sellmair.io/")
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    plugins {
        val kotlinVersion = "1.9.255-SNAPSHOT"
        //val kotlinVersion = "1.9.20-stdlib-01"
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion

        val androidVersion = "8.0.2"
        id("com.android.application") version androidVersion
        id("com.android.library") version androidVersion
    }

}

dependencyResolutionManagement {
    repositories {
        maven("https://repo.sellmair.io/")
        mavenLocal()
        mavenCentral()
        google()
    }
}

include(":p1")
