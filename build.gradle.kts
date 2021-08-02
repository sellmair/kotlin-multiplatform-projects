plugins {
    id("com.android.application")
    kotlin("multiplatform")
}

repositories {
    google()
    mavenLocal()
    mavenCentral()
}

android {
    compileSdkVersion(30)
}

kotlin {
    android()
}
