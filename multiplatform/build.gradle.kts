import org.gradle.kotlin.dsl.provider.inLenientMode

plugins {
    kotlin("multiplatform")
}

error("Is lenient: ${inLenientMode()}")

kotlin {
    jvm()
}