plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    iosX64()
    iosSimulatorArm64()
    iosArm64()

    sourceSets.commonTest.dependencies {
        implementation(kotlin("test"))
    }
    sourceSets.nativeMain.dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    }
}
