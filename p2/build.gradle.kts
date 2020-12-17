plugins {
    kotlin("multiplatform")
}


//region Project Structure

kotlin {
    val macos = macosX64("macos")
    val linux = linuxX64("linux")

    val commonMain = sourceSets.getByName("commonMain")
    val nativeMain = sourceSets.create("nativeMain")
    val macosMain = sourceSets.getByName("macosMain")
    val linuxMain = sourceSets.getByName("linuxMain")

    nativeMain.dependsOn(commonMain)
    macosMain.dependsOn(nativeMain)
    linuxMain.dependsOn(nativeMain)

    commonMain.dependencies {
        implementation(kotlin("stdlib-common"))
    }

    nativeMain.dependencies {
        implementation(project(":p1"))
    }

    macosMain.dependencies {
    }

    linuxMain.dependencies {
    }

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }
}

tasks.create("attrs") {
    doLast {
        configurations.all {
            println("Configuration $name")
            println("Attributes: ${this.attributes}")
            println("Extends: ${this.extendsFrom.map { it.name }}")
            println("isCanBeConsumed: ${this.isCanBeConsumed}")
            println("isCanBeResolved: ${this.isCanBeResolved}")
            println("________________________________")
        }
    }
}
