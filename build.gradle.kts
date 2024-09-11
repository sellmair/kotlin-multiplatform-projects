plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    jvm()
    androidTarget()
    iosX64()
    iosSimulatorArm64()
    iosArm64()
    sourceSets {
        getByName("commonTest") {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    compileSdk = 34
    namespace = "org.jetbrains.sample"
}
