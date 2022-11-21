pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
    plugins {
        //kotlin("multiplatform") version "1.8.255-SNAPSHOT"
        kotlin("multiplatform") version "1.7.0"
    }
}

include(":producer")
include(":consumer")
