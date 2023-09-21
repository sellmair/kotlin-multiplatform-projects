import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdk = 33
    namespace = "org.jetbrains.sample.p1"
}

kotlin {
    macosX64()
    androidTarget()
    jvm()

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    applyDefaultHierarchyTemplate {
        common {
            group("jvmCommon") {
                withJvm()
                withAndroidTarget()
            }
        }
    }

    sourceSets.commonTest.dependencies {
        implementation(kotlin("test-annotations-common"))
        implementation(kotlin("test-common"))
    }

    sourceSets.getByName("jvmCommonMain").dependencies {
        implementation(kotlin("test-junit"))
    }
}
