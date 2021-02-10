@file:Suppress("LeakingThis")

import org.jetbrains.kotlin.gradle.plugin.mpp.includeInXCFramework
import org.jetbrains.kotlin.gradle.plugin.mpp.registerBuildFrameworkForXCodeTask

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    ios {
        binaries.framework {
            includeInXCFramework("ios")
            registerBuildFrameworkForXCodeTask()
        }
    }
}



