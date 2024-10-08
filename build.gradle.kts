plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlinx.benchmark")
}

kotlin {
    jvm()
    jvmToolchain(8)
    macosArm64()
    wasmJs {
        nodejs()
    }

    sourceSets.commonMain.dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.12")
    }
}

benchmark {
    targets {
        register("jvm")
        register("macosArm64")
        register("wasmJs")
    }
}