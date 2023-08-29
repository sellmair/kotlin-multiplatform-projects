plugins {
    kotlin("multiplatform")
}


kotlin {
    jvm()
    linuxX64()

    sourceSets.commonMain.dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    }
}
