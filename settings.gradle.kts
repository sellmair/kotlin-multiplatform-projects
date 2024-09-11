pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")

        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        val kotlinVersion = "2.1.0-dev-6359"
        kotlin("multiplatform") version kotlinVersion
        id("org.jetbrains.kotlinx.benchmark") version "0.4.11"
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")

        mavenLocal()
        mavenCentral()
    }
}
