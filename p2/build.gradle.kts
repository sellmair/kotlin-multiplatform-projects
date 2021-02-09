/**
 * INTEROP BUNDLE CONSUMER (p2)
 */

plugins {
    kotlin("multiplatform")
}

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
        // option 1
        //implementation("io.sellmair:libcurl:7.64.1-kib0")

        // option 2 (also works)
        //implementation(project(":p1"))
    }

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }

    macos.compilations.getByName("main").cinterops.create("curl")
    linux.compilations.getByName("main").cinterops.create("curl")
}

