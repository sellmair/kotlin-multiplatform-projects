plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(30)
}

dependencies {
    implementation(project(":p1"))
}

/*
kotlin {
    iosX64()
    jvm()
    android()

    val commonMain by sourceSets.getting
    val jvmAndAndroidMain by sourceSets.creating
    val androidMain by sourceSets.getting
    val jvmMain by sourceSets.getting

    jvmMain.dependsOn(jvmAndAndroidMain)
    androidMain.dependsOn(jvmAndAndroidMain)
    jvmAndAndroidMain.dependsOn(commonMain)
}

dependencies {
    testImplementation("com.squareup.okio:okio:3.1.0")
}
 */