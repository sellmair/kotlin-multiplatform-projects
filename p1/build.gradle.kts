plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    macosX64("macos")
    linuxX64("linux")

    sourceSets {

        val commonMain = getByName("commonMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
                // Its transitive "kotlinx-coroutines-core:1.4.2-*native-mt* dependency gets override!!!
                implementation("io.ktor:ktor-client-core:1.4.2")
            }
        }

        val nativeMain = create("nativeMain") {
            dependsOn(commonMain)
        }

        getByName("macosMain") {
            dependsOn(nativeMain)
        }

        getByName("linuxMain") {
            dependsOn(nativeMain)
        }
    }
}
