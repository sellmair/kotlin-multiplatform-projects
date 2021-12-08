plugins {
    kotlin("multiplatform") version "1.6.20-dev-6642"
}

group = "me.user"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
}

kotlin {
    linuxX64 {
        binaries {
            executable("linuxX64Executable")
        }
    }
    linuxMips32 {
        binaries {
            executable("linux32Executable")
        }
    }
//    macosX64 {
//        binaries {
//            executable("macosBinary") {
//            }
//        }
//    }
//    iosArm32 {
//        binaries {
//            framework {
//                baseName = "library"
//            }
//        }
//    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:platform-integers:1.6.20-dev-6642")
            }
        }
    }

    sourceSets.all {
        languageSettings.optIn("kotlin.RequiresOptIn")
    }
}
