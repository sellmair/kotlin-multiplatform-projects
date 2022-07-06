plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdk = 31
    sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
}

kotlin {
    android()
    jvm()
    iosX64()

    val commonMain by sourceSets.getting
    val androidMain by sourceSets.getting
    val jvmMain by sourceSets.getting
    val androidAndJvmMain by sourceSets.creating

    androidAndJvmMain.dependsOn(commonMain)
    jvmMain.dependsOn(androidAndJvmMain)
    androidMain.dependsOn(androidAndJvmMain)

    androidMain.dependencies {
        implementation(project(":multiplatformAndroidLibrary"))
    }
}