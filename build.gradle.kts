import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
    mavenLocal()
}


kotlin {
    val nativeTarget = when {
        HostManager.hostIsMac -> macosX64("native")
        HostManager.hostIsMingw -> mingwX64("native")
        HostManager.hostIsLinux -> linuxX64("native")
        else -> error("Unexpected host: ${HostManager.host}")
    }

    nativeTarget.compilations["main"].cinterops.create("sampleInterop") {
        header(file("src/nativeInterop/cinterop/sampleInterop.h"))
    }

    val nativeTest by sourceSets.getting
    val nativeIntermediateTest by sourceSets.creating
    nativeIntermediateTest.dependsOn(nativeTest)
}
