pluginManagement {
    repositories {
        mavenCentral()
        google()
    }

    plugins {
        val kotlinVersion = "2.1.21"
        kotlin("multiplatform") version kotlinVersion
        kotlin("android") version kotlinVersion

        val androidVersion = "8.7.3"
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
