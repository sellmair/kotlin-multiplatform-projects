allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
        jcenter()
    }
}

plugins {
    kotlin("multiplatform") apply false
    kotlin("jvm") apply false
}