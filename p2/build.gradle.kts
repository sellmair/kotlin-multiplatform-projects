plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(30)
}

dependencies {
    implementation(project(":p1"))
}

tasks.register("printAllConfigurations") {
    doLast {
        logger.quiet(project.configurations.map { it.name }.joinToString("\n"))
    }
}