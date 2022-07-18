plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android {
    compileSdk = 31
}

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    android()
    jvm()
    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting

    commonMain.dependencies {
        implementation("com.russhwolf:multiplatform-settings:1.0.0-alpha01")
    }

    commonTest.dependencies {
        implementation(kotlin("test-junit"))
    }
}
