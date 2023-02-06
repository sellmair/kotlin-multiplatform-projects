@file:Suppress("OPT_IN_USAGE")

plugins {
    id("com.android.library")
    id("multiplatform")
}

android {
    compileSdk = 33
}

kotlin {
    iosArm64()
    iosX64()
    macosArm64()
    macosX64()
    linuxArm64()
    linuxX64()

    jvm()
    android()
}
