import org.jetbrains.kotlin.gradle.android.androidTargetPrototype

plugins {
    id("com.android.application")
    kotlin("multiplatform")
    `maven-publish`
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