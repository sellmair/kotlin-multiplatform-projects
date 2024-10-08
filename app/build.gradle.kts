plugins {
    kotlin("multiplatform")
    id("com.android.application")
}


repositories {
    mavenCentral()
    google()
    maven(rootDir.resolve("lib/repo"))
}

kotlin {
    jvmToolchain(17)

    jvm()
    androidTarget()
    macosArm64()

    sourceSets.commonMain.dependencies {
        implementation("org.jetbrains.sample:lib:1.0.0")
    }

    sourceSets.commonTest.dependencies {
        implementation(kotlin("test"))
    }
}

android {
    compileSdk = 34
    namespace = "org.jetbrains.sample.app"
}