plugins {
    //id("com.android.library")
    kotlin("multiplatform")
}

/*
android {
    compileSdkVersion(30)
}

 */

kotlin {
    //android()
    macosX64()
    ios()

    val commonTest by sourceSets.getting
    
    commonTest.dependencies {
        implementation("io.mockk:mockk:1.11.0")
    }
}
