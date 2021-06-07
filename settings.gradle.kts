pluginManagement {
    val kotlinVersion = "1.5.255-SNAPSHOT"
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        mavenLocal()
    }
    plugins {
        kotlin("multiplatform") version kotlinVersion
    }
}

