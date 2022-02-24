//import org.jetbrains.kotlin.gradle.android.multiplatform.android2

plugins {
    id("com.android.application")
    //id("kotlin-android-target")
    kotlin("multiplatform")
    `maven-publish`
}

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 30
        signingConfig = signingConfigs.getByName("debug")
    }

    testOptions {
        //unitTests.isIncludeAndroidResources = true
    }
}

kotlin {
    jvm()
    android()

    val commonMain by sourceSets.getting


    commonMain.dependencies {
        implementation(kotlin("stdlib"))
    }

}
