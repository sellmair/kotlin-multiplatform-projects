allprojects {
    repositories {
        mavenCentral()
        maven("https://dl.bintray.com/sellmair/testing")
        google()
        mavenLocal()
        jcenter()
    }
}

plugins {
    kotlin("multiplatform") apply false
}
