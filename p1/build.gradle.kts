plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(30)
}

dependencies {
    implementation(project(":p2"))
}
