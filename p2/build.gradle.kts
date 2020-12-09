import org.jetbrains.kotlin.gradle.targets.native.internal.ConfigurationCommonizerTask

plugins {
    kotlin("multiplatform")
}


kotlin {
    val macos = macosX64("macos")
    val linux = linuxX64("linux")

    tasks.create<ConfigurationCommonizerTask>("commonizeCurl") {
        addLibrary(macos, files("libs/macos_x64/curl.klib"))
        addLibrary(linux, files("libs/linux_x64/curl.klib"))
    }

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
        //implementation(curl)
    }

    macosMain.dependencies {
        implementation(files("libs/macos_x64/curl.klib"))
    }

    linuxMain.dependencies {
        implementation(files("libs/linux_x64/curl.klib"))
    }

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }
}

