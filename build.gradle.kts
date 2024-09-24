plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    macosX64()
    macosArm64()
    sourceSets.commonTest.dependencies {
        implementation(kotlin("test"))
    }
}