pluginManagement {
    repositories {
        mavenCentral()
        google()
    }

    plugins {
        val kotlinVersion = "2.0.0-RC1"
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion

        val androidVersion = "8.2.0"
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
