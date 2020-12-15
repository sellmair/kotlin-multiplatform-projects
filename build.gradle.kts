plugins {
    kotlin("multiplatform") apply false
}

val x = 1

allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
        jcenter()
    }
}
