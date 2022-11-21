import org.jetbrains.kotlin.gradle.android.androidTargetPrototype

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    `maven-publish`
}

group = "org.jetbrains.sample"
version = "1.0.0"


publishing {
    repositories {
        maven(buildDir.resolve("repo")) {
            name = "build"
        }
    }
}

android {
    compileSdk = 33
    defaultConfig {
        minSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

kotlin {
    val android = androidTargetPrototype()
    jvm()
    android.androidDsl.compileSdk = 23
    android.compilations.all {
        androidCompilationSpecificStuff = 23020
    }


    sourceSets.invokeWhenCreated("prototypeAndroidMain") {
        dependencies {
            implementation("androidx.appcompat:appcompat:1.6.0-rc01")
        }
    }

    sourceSets.invokeWhenCreated("prototypeAndroidUnitTest") {
        dependencies {
            implementation(kotlin("stdlib"))
            implementation(kotlin("test-junit"))
        }
    }


    tasks.create("debug") {
        doLast {
            targets.getByName("android").compilations.getByName("main")
                .compileDependencyFiles.files.forEach {
                    logger.quiet(it.path)
                }
        }
    }

}


tasks.register("printMainCompilationClasspath") {
    val files = project.files({
        project.configurations.getByName(kotlin.targets.getByName("android").compilations.getByName("main").compileDependencyConfigurationName)
    })

    inputs.files(files)

    doLast {
        files.files.forEach { file ->
            logger.quiet(file.path)
        }
    }
}

tasks.register("printAllConfigurations") {
    doLast {
        logger.quiet(project.configurations.map { it.name }.joinToString("\n"))
    }
}