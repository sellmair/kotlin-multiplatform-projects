plugins {
    kotlin("multiplatform") apply false
}


allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
        jcenter()
    }
}
