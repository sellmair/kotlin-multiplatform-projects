import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    `maven-publish`
}

group = "org.jetbrains.sample"
version = "1.0.0"

android {
    compileSdk = 34
    namespace = "org.jetbrains.sample.lib"
}

kotlin {
    jvmToolchain(17)

    macosArm64()
    linuxX64()
    jvm()

    androidTarget {
        // Most of the time there is no reason for publishing the debug variant!!
        publishLibraryVariants("release")
    }
}

/*
Example: Share code between JVM and Android
 */
kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class) // OK for JetBrains builds of course!
    applyDefaultHierarchyTemplate {
        common {
            group("jvmAndAndroid") {
                withJvm()
                withAndroidTarget()
            }
        }
    }
}


/*
Sample: Publish to a directory and check-in this directory so we can browse what is published!
 */
publishing {
    repositories {
        maven(file("repo"))
    }
}

tasks.clean.configure {
    delete("repo")
}