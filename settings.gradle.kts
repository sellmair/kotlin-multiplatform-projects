pluginManagement {
    repositories {
        mavenCentral()
        google()
    }

    plugins {
        val kotlinVersion = "2.0.20"
        kotlin("multiplatform") version kotlinVersion
        kotlin("plugin.compose") version kotlinVersion
        kotlin("android") version kotlinVersion

        val androidVersion = "8.5.1"
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
