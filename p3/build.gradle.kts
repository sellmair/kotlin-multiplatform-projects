plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(30)
}

repositories {
    maven("/Users/sebastiansellmair/TestProjects/kotlin-multiplatform-projects/p1/build/repo")
}

dependencies {
    implementation("org.jetbrains.sample:p1:1.0.0")
}

tasks.register("printAllConfigurations") {
    doLast {
        logger.quiet(project.configurations.map { it.name }.joinToString("\n"))
    }
}