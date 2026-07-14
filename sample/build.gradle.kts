import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    id("maven-publish")
}

group = rootProject.group
version = rootProject.version

kotlin {
    jvm()
    js {
        browser()
        nodejs()
    }
    iosArm64()
    iosSimulatorArm64()
    linuxX64()

    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.coroutines.core)
        }
    }

    targets.withType<KotlinNativeTarget>().configureEach {
        compilations.getByName("main") {
            cinterops.create("foo") {
                definitionFile.set(project.file("src/foo.def"))
                includeDirs(project.file("src"))
            }
        }
    }
}

publishing {
    repositories {
        maven {
            name = "projectLocal"
            url = rootProject.layout.projectDirectory.dir("local-maven-repo").asFile.toURI()
        }
    }
}

tasks.matching { it.name == "commonizeNativeDistribution" }.configureEach {
    onlyIf("Run only when commonized native distribution outputs are missing") {
        val outputRoots = outputs.files.files
        if (outputRoots.isEmpty()) return@onlyIf true

        outputRoots.any { output ->
            !output.exists() || (output.isDirectory && output.list()?.isEmpty() != false)
        }
    }
}

