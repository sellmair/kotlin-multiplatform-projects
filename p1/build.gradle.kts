plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdk = 33
    namespace = "org.jetbrains.sample.p1"
}

kotlin {
    jvm()
    androidTarget()


    val root = sourceSets.create("root")
    sourceSets.commonMain.configure {
        dependsOn(root)
    }
}
