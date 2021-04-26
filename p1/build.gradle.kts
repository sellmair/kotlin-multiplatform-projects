plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdkVersion(30)
}

kotlin {
    jvm()
    js().nodejs()
    android()
    sourceSets {
        val commonMain = getByName("commonMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
            }
        }

        val jvmAndAndroidMain = create("jvmAndAndroidMain") {
            dependsOn(commonMain)
        }

        getByName("androidMain") {
            dependsOn(jvmAndAndroidMain)
        }

        getByName("jvmMain") {
            dependsOn(jvmAndAndroidMain)
        }
    }
}
