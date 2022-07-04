plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdkVersion(30)
}

kotlin {
    android()
    
    val commonMain by sourceSets.getting
    val androidTest by sourceSets.getting

    commonMain.dependencies {
        implementation(project(":p1"))
    }

}
