import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget


plugins {

    kotlin("multiplatform")
}

kotlin {
    jvm()
    js(IR).nodejs()
    linuxX64()
    macosX64()
    mingwX64("windowsX64")
}
