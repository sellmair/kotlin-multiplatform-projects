plugins {
    kotlin("multiplatform") version "1.4.30" apply false
}

allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
        jcenter()
    }
}
