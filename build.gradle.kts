plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
}

kotlin {
    jvm()
    //linuxX64()
    sourceSets.commonMain.dependencies {
       implementation("org.jetbrains.compose.foundation:foundation-desktop:1.6.11")
    }
}
