@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("multiplatform")
}


kotlin {
    jvm()
    js(IR)

    linuxX64()
    linuxArm64()

    targetHierarchy.default {
        common {
            group("jvmAndJs") {
                withJs()
                withJvm()
            }
        }
    }

    sourceSets.all {
        languageSettings.languageVersion = "2.0"
    }

    targets.all {
        compilations.all {
            compilerOptions.configure {
               // languageVersion.set(KotlinVersion.KOTLIN_2_0)
            }
        }
    }
}
