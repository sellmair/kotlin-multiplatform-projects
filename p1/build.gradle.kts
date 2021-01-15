plugins {
    kotlin("multiplatform")
}

kotlin {
    macosX64("macos")
    linuxX64("linux")

    val commonMain by sourceSets.getting
    val nativeMain by sourceSets.creating
    val macosMain by sourceSets.getting
    val linuxMain by sourceSets.getting

    nativeMain.dependsOn(commonMain)
    macosMain.dependsOn(nativeMain)
    linuxMain.dependsOn(nativeMain)
}
