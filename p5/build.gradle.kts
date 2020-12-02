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
        val commonMain by getting
        val jvmAndAndroidMain = create("jvmAndAndroidMain") {
            dependsOn(commonMain)
        }

        getByName("jvmMain") {
            dependsOn(jvmAndAndroidMain)
        }

        getByName("androidMain") {
            dependsOn(jvmAndAndroidMain)
        }
    }
}
