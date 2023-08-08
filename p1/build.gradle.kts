plugins {
    kotlin("multiplatform")
}


kotlin {
    jvm()
    iosX64()
    iosArm64()

    sourceSets.commonMain.dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2-1.9.20-stdlib")
    }
}
