plugins {
    `maven-publish`
    id("com.android.library")
    kotlin("multiplatform")
}

version = "1.0.0-SNAPSHOT"

publishing {
    repositories {
        maven(rootProject.buildDir.resolve("repo")) {
            name = "buildDir"
        }
    }
}

android {
    compileSdkVersion(30)
}

kotlin {
    jvm()
    android {
        publishAllLibraryVariants()
    }
}
