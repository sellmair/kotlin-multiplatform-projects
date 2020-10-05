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
        getByName("commonMain") {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}

