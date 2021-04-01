import org.jetbrains.kotlin.gradle.dsl.invoke
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

kotlin {
    linuxX64()
    linuxArm64()
    macosX64("macos")
    jvm()
    ios()
    js()

    val commonMain by sourceSets.getting
    val concurrentMain by sourceSets.creating
    val jvmMain by sourceSets.getting
    val nativeMain by sourceSets.creating
    val linuxMain by sourceSets.creating
    val linuxX64Main by sourceSets.getting
    val linuxArm64Main by sourceSets.getting
    val darwinMain by sourceSets.creating
    val macosMain by sourceSets.getting
    val iosMain by sourceSets.getting
    val jsMain by sourceSets.getting

    commonMain {
        -jsMain
        -concurrentMain {
            -jvmMain
            -nativeMain {
                -darwinMain {
                    -iosMain
                    -macosMain
                }
                -linuxMain {
                    -linuxArm64Main
                    -linuxX64Main
                }
            }
        }
    }


    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }

    targets.withType<KotlinNativeTarget>().forEach { target ->
        target.compilations.getByName("main").cinterops.create("withPosix") {
            header(file("libs/withPosix.h"))
        }
    }
}
