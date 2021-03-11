/**
 * INTEROP BUNDLE CONSUMER (p2)
 */

plugins {
    kotlin("multiplatform")
}

kotlin {
    val macos = macosX64("macos")
    val linux = linuxX64("linux")

    val commonMain by sourceSets.getting
    val nativeMain by sourceSets.creating
    val macosMain by sourceSets.getting
    val linuxMain by sourceSets.getting

    nativeMain.dependsOn(commonMain)
    macosMain.dependsOn(nativeMain)
    linuxMain.dependsOn(nativeMain)

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }

    macos.compilations.getByName("main").cinterops.create("curl")
    linux.compilations.getByName("main").cinterops.create("curl")
    macos.compilations.getByName("main").cinterops.create("sqlite")
    linux.compilations.getByName("main").cinterops.create("sqlite")
}
