plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
}

kotlin {
    jvm()
    sourceSets.commonMain.dependencies {
        implementation("org.jetbrains.compose.foundation:foundation-desktop:1.6.11")
    }
}
