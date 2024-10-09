import com.android.build.api.variant.TestVariant

plugins {
    kotlin("android")
    id("com.android.library")
    id("androidx.benchmark")
}

kotlin {
    jvmToolchain(17)
}

android {
    compileSdk = 34
    namespace = "org.jetbrains.sample"

    buildTypes {
        all {
           // isDebuggable = false
        }
    }

    buildTypes {

        defaultConfig {
            minSdk = 21
            testInstrumentationRunner = "androidx.benchmark.junit4.AndroidBenchmarkRunner"
            testInstrumentationRunnerArguments["androidx.benchmark.suppressErrors"] = "EMULATOR,LOW-BATTERY"

        }
    }
}

dependencies {
    androidTestImplementation(kotlin("test-junit"))
    androidTestImplementation("androidx.benchmark:benchmark-junit4:1.3.2")

    // Core library
    androidTestImplementation("androidx.test:core:1.6.1")

    // AndroidJUnitRunner and JUnit Rules
    androidTestImplementation("androidx.test:runner:1.6.2")
    androidTestImplementation("androidx.test:rules:1.6.1")

}

