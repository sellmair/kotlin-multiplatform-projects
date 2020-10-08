plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
    jcenter()
    google()
}

android {
    compileSdkVersion(30)
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        minSdkVersion(16)
    }
    sourceSets {
        getByName("main").java.srcDir(file("src/androidMain/kotlin"))
        getByName("test").java.srcDir(file("src/androidTest/kotlin"))
        getByName("androidTest").java.srcDir(file("src/androidAndroidTest/kotlin"))
    }
}

kotlin {
    jvm()
    android()

    sourceSets {
        getByName("commonTest") {
            dependencies{
                implementation(kotlin("test-junit"))
            }
        }
    }
}
