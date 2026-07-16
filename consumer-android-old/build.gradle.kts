plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    compileSdk = 32
    namespace = "consumer"
    defaultConfig {
        compileOptions {
            this.sourceCompatibility = JavaVersion.VERSION_21
            this.targetCompatibility = JavaVersion.VERSION_21
        }
    }
}

kotlin {
    components {

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

dependencies {
    implementation("local.test.kgp:sample:1.0.0")
}