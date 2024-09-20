plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlinx.benchmark")
}

kotlin {
    jvm()
    macosArm64()
    wasmJs {
        nodejs()
    }

    sourceSets.commonMain.dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.5.0-SNAPSHOT")
    }
}

benchmark {
    targets {
        register("jvm")
        register("macosArm64")
        register("wasmJs")
    }
}