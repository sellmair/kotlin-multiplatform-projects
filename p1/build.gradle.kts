@file:Suppress("LeakingThis")

import org.jetbrains.kotlin.gradle.plugin.mpp.buildForXCode
import org.jetbrains.kotlin.gradle.plugin.mpp.includeIntoXCFramework


plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    ios {
        binaries.framework {
            includeIntoXCFramework("ios") {
                outputDirectory.set(rootProject.buildDir.resolve("xcode"))
                frameworkName.set("p1-ios")
            }
            buildForXCode {
                outputDirectory.set(rootProject.buildDir.resolve("xcode"))
            }
        }
    }
}



