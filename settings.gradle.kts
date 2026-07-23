pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
    }

    plugins {
        val kotlinVersion = "2.5.255-SNAPSHOT"
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