plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm()
    macosX64("macos")
    linuxX64()

    sourceSets {

        val commonMain = getByName("commonMain") {
            dependencies {
                implementation("io.ktor:ktor-client-core:1.4.3")
                implementation("io.ktor:ktor-client-serialization:1.4.3")

                implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2-native-mt")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
            }
        }

        val commonTest = getByName("commonTest") {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val nativeMain = create("nativeMain") {
            dependsOn(commonMain)
            dependencies {
                implementation("io.ktor:ktor-client-curl:1.4.3")
            }
        }


        /* Linux */

        getByName("linuxX64Main") {
            dependsOn(nativeMain)
            dependencies {
            }
        }


        /* Macos */

        getByName("macosMain") {
            dependsOn(nativeMain)
            dependencies {
            }
        }

        /* JVM */

        getByName("jvmMain") {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("io.ktor:ktor-client-okhttp:1.4.3")
            }
        }

        all {
            this.languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
            this.languageSettings.useExperimentalAnnotation("kotlin.time.ExperimentalTime")
            this.languageSettings.useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes")
        }
    }
}
