plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(30)
}

dependencies {
    implementation(project(":p2"))
}
