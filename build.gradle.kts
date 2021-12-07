plugins {
    kotlin("multiplatform") version "1.6.20-dev-6563"
}

group = "me.user"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
}

kotlin {
    linuxX64()
    macosX64 {
        binaries {
            executable("macosBinary") {
            }
        }
    }
    iosArm32 {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:platform-integers:1.6.255-default-publishing")
            }
        }
    }

    sourceSets.all {
        languageSettings.optIn("kotlin.RequiresOptIn")
    }
}
