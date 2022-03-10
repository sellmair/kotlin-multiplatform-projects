allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}

plugins {
    kotlin("multiplatform") version "1.6.10" apply false
    kotlin("android") version "1.6.10" apply false
    id("com.android.application") apply false
}
