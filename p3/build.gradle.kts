import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.HostManager

repositories {
    maven {
        url = rootProject.buildDir.resolve("repo").toURI()
    }
}

plugins {
    kotlin("multiplatform")
}

kotlin {
    linuxX64()
    linuxArm64()

    targets.withType<KotlinNativeTarget>().configureEach {
        if (!HostManager().isEnabled(konanTarget)) {
            error("Expected all targets to be supported. $konanTarget is disabled on this host!")
        }
    }

    sourceSets.commonMain.get().dependencies {
        when (val dependencyMode = project.properties["dependencyMode"]?.toString() ?: "repository") {
            "project" -> {
                logger.quiet("dependencyMode = 'project'")
                implementation(project(":p1"))
            }

            "repository" -> {
                logger.quiet("dependencyMode = 'repository'")
                implementation("kotlin-multiplatform-projects:p1:1.0.0")
                api("kotlin-multiplatform-projects:p1:1.0.0")
                runtimeOnly("kotlin-multiplatform-projects:p1:1.0.0")
                compileOnly("kotlin-multiplatform-projects:p1:1.0.0")
            }

            else -> error("Invalid dependencyMode = '$dependencyMode'")
        }
    }
}
