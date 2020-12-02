plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdkVersion(30)
}

kotlin {
    android()
    jvm()

    sourceSets {
        getByName("commonMain") {
            dependencies {
                api(project(":p3"))
                api(project(":p4"))
                api(project(":p5"))
            }
        }
    }
}
