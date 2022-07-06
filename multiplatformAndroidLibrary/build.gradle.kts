plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android {
    compileSdk = 31
    sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

kotlin {
    android()

    val commonMain by sourceSets.getting
    commonMain.dependencies {
        implementation(kotlin("stdlib"))
        implementation(project(":multiplatformAndroidJvmIosLibrary"))
        implementation("com.squareup.okio:okio:3.2.0")
    }
}
