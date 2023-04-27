plugins {
    kotlin("multiplatform")
    //id("com.android.library")
}

/*
android {
    compileSdk = 33
}

 */

kotlin {
    iosX64()
    iosArm64()
   // androidTarget()
}