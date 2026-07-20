pluginManagement {
    repositories {
        mavenCentral()
    }

    plugins {
        val kotlinVersion = "2.4.10"
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

include(":sample")