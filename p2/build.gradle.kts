@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.plugin.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.plugin.mpp.hierarchy.withHierarchy
import org.jetbrains.kotlin.gradle.plugin.mpp.hierarchy.withNaturalHierarchy

plugins {
    id("multiplatform")
}


tasks.create("debugMe") {
    doLast {
        kotlin.sourceSets.forEach { sourceSet ->
            logger.quiet("${sourceSet.name}: ${sourceSet.dependsOn.map { it.name }}")
        }
    }
}