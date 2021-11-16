import org.jetbrains.kotlin.gradle.android.android2

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-external-target-api:1.6.255-SNAPSHOT@jar")
    }
}

plugins {
    id("com.android.application")
    id("kotlin-android-target")
    kotlin("multiplatform")
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
    android2()

    val commonMain by sourceSets.getting
    val androidMain by sourceSets.getting
    val androidUnitTest by sourceSets.getting

    commonMain.dependencies {
        implementation(kotlin("stdlib"))
    }

    androidMain.dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("androidx.appcompat:appcompat:1.3.1")
    }

    androidUnitTest.dependencies {
        implementation(kotlin("test-junit"))
        implementation("androidx.test:core:1.4.0")
        implementation("androidx.test:core-ktx:1.4.0")
    }
}
