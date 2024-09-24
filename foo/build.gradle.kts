plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    macosX64()
    macosArm64()

    iosSimulatorArm64()
    iosArm64()
    sourceSets.jvmTest.dependencies {
        implementation(kotlin("test"))
    }
}