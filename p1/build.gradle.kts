plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdk = 34
    namespace = "org.jetbrains.sample.p1"
}

kotlin {
    androidTarget()
    iosX64()
    iosSimulatorArm64()
    iosArm64()
}
