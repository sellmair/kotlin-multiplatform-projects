plugins {
    kotlin("multiplatform")
}

kotlin {
    val linuxX64 = linuxX64()
    val linuxArm64 = linuxArm64()
    val macos = macosX64("macos")

    val commonMain by sourceSets.getting
    val nativeMain by sourceSets.creating
    val linuxMain by sourceSets.creating
    val linuxX64Main by sourceSets.getting
    val linuxArm64Main by sourceSets.getting
    val macosMain by sourceSets.getting

    nativeMain.dependsOn(commonMain)
    linuxMain.dependsOn(nativeMain)
    linuxX64Main.dependsOn(linuxMain)
    linuxArm64Main.dependsOn(linuxMain)
    macosMain.dependsOn(nativeMain)

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }

    listOf(linuxArm64, linuxX64, macos).forEach { target ->
        target.compilations.getByName("main").cinterops.create("withPosix") {
            header(file("libs/withPosix.h"))
        }
    }
}
