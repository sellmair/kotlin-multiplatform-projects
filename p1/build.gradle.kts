plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdkVersion(30)
}

kotlin {
    jvm()
    android()
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(project(":p2"))
            }
        }
    }
}
