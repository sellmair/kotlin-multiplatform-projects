plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.multiplatform.library)
}

kotlin {
    jvmToolchain(21)

    android {
        compileSdk = 32
        namespace = "consumer"
    }

    sourceSets {
        androidMain.dependencies {
            implementation("local.test.kgp:sample:1.0.0")
        }
    }
}

repositories {
    maven(file("../local-maven-repo"))
    maven(file("/Users/Sebastian.Sellmair/JetBrainsProjects/kotlinx.coroutines/build/build-local-repository"))
    google()

    mavenCentral()
    mavenLocal()
    maven("https://packages.jetbrains.team/maven/p/kt/dev")
}