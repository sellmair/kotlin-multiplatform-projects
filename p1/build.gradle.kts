plugins {
    kotlin("multiplatform")
}

kotlin {
    mingwX64()
    mingwX86()
    linuxX64()
    linuxArm32Hfp()
    linuxArm64()
    macosX64()
    watchos()
    ios()
}