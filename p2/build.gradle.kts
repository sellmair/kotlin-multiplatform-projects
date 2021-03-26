plugins {
    kotlin("multiplatform")
}

kotlin {
    val x64 = linuxX64("x64")
    val arm64 = linuxArm64("arm64")

    val commonMain by sourceSets.getting
    val nativeMain by sourceSets.creating
    val x64Main by sourceSets.getting
    val arm64Main by sourceSets.getting

    nativeMain.dependsOn(commonMain)
    x64Main.dependsOn(nativeMain)
    arm64Main.dependsOn(nativeMain)

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }

    listOf(x64, arm64).forEach { target ->
        target.compilations.getByName("main").cinterops.create("withPosix") {
            header(file("libs/withPosix.h"))
        }
    }
}
