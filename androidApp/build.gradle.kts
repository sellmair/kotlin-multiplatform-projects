plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("androidx.appcompat:appcompat:1.4.2")

    implementation(project(":multiplatformAndroidJvmIosLibrary"))
    implementation(project(":multiplatformJvmLibrary"))
    implementation(project(":multiplatformAndroidLibrary"))
    implementation(project(":jvmLibrary"))
}