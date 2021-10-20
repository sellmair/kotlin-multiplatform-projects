import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    kotlin("multiplatform") apply false
}

allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }

    afterEvaluate {
        val compileAllTests by tasks.creating
        val kotlin = extensions.findByType<KotlinMultiplatformExtension>() ?: return@afterEvaluate
        kotlin.targets.all {
            val compileTask = compilations.findByName("test")?.compileKotlinTask ?: return@all
            compileAllTests.dependsOn(compileTask)
        }
    }
}
