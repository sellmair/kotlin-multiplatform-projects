plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android {
    compileSdkVersion(30)
}

kotlin {
    js()
    jvm()
    android()
}
