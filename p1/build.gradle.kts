plugins {
    kotlin("multiplatform")
}

kotlin {
    linuxX64()
    macosX64()
    ios()
    jvm()

    val commonMain by sourceSets.getting
    val iosMain by sourceSets.getting
    val linuxX64Main by sourceSets.getting
    val macosX64Main by sourceSets.getting

    val nativeMain by sourceSets.creating
    nativeMain.dependsOn(commonMain)
    iosMain.dependsOn(nativeMain)
    linuxX64Main.dependsOn(nativeMain)
    macosX64Main.dependsOn(nativeMain)

    commonMain.dependencies {
        implementation("io.ktor:ktor-client-core:+")
    }
}