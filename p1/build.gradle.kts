import com.android.build.gradle.internal.scope.ProjectInfo.Companion.getBaseName
import org.jetbrains.kotlin.gradle.android.androidTargetPrototype

plugins {
    id("com.android.application")
    kotlin("multiplatform")
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
    androidTargetPrototype()

    sourceSets.invokeWhenCreated("androidMain") {
        dependencies {
            implementation("androidx.appcompat:appcompat:1.6.0-rc01")
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.0-rc01")
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