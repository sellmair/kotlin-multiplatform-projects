plugins {
    kotlin("multiplatform") apply false
}


allprojects {
    repositories {
        mavenCentral()
        google()
        maven(rootProject.file("repo"))
    }
}


