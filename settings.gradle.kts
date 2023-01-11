pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap/")
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        val kv = "1.8.255-SNAPSHOT"
        kotlin("multiplatform") version kv
        kotlin("android") version kv
        id("com.android.application") version "7.3.1"
        id("com.android.library") version "7.3.1"
    }

}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap/")
        mavenLocal()
    }
}

include(":p1")
//include(":p2")
