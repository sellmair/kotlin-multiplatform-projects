import org.jetbrains.kotlin.com.intellij.openapi.util.SystemInfo.*
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

operator fun KotlinSourceSet.invoke(builder: SourceSetHierarchyBuilder.() -> Unit): KotlinSourceSet {
    SourceSetHierarchyBuilder(this).builder()
    return this
}

class SourceSetHierarchyBuilder(private val node: KotlinSourceSet) {
    operator fun KotlinSourceSet.unaryMinus() = this.dependsOn(node)
}

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

publishing {
    repositories {
        this.maven {
            this.name = "build"
            this.url = buildDir.resolve("repo").toURI()
        }
    }
}

kotlin {

    val nativePlatform = when {
        isMac -> macosX64("nativePlatform")
        isLinux -> linuxX64("nativePlatform")
        isWindows -> mingwX64("nativePlatform")
        else -> throw IllegalStateException("Unsupported host")
    }

    val commonMain by sourceSets.getting
    val nativeMain by sourceSets.creating
    val nativePlatformMain by sourceSets.getting

    commonMain {
        -nativeMain {
            -nativePlatformMain
        }
    }

    tasks.register("listNativePlatformMainDependencies") {
        doLast {
            val dependencyFiles = nativePlatform.compilations["main"].compileDependencyFiles.files +

                    project.configurations.getByName(
                        nativePlatformMain.implementationMetadataConfigurationName
                    ).files +

                    project.configurations.findByName(
                        "intransitive" + nativePlatformMain.implementationMetadataConfigurationName.capitalize()
                    )?.files.orEmpty()

            logger.quiet("NativePlatformMainDependency | Count: ${dependencyFiles.size}")
            dependencyFiles.forEach { dependencyFile ->
                logger.quiet("NativePlatformMainDependency: ${dependencyFile.path}")
            }
        }
    }
}


