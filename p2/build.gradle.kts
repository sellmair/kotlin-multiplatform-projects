import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js().nodejs()

    linuxX64()
    linuxArm64()
    macosX64()
    ios()
    mingwX64("windowsX64")
    mingwX86("windowsX86")

    targets.withType<KotlinNativeTarget>().forEach { target ->
        target.compilations.all {
            cinterops.create("withPosix") {
                header(file("libs/withPosix.h"))
            }

            cinterops.create("withPosixP2") {
                header(file("libs/withPosixP2.h"))
            }
        }
    }
}
