import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlinx.benchmark")
}

kotlin {
    jvm()
    macosArm64()

    sourceSets.commonMain.dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.11")
    }
}

benchmark {
    targets {
        register("jvm")
        register("macosArm64")
    }
}