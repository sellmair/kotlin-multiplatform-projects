plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

repositories {
    maven(file("../local-maven-repo"))
    maven(file("/Users/Sebastian.Sellmair/JetBrainsProjects/kotlinx.coroutines/build/build-local-repository"))

    mavenCentral()
    mavenLocal()
    maven("https://packages.jetbrains.team/maven/p/kt/dev")

}

kotlin {
    jvm()
    linuxX64()
    macosArm64().binaries {
        executable {
            entryPoint = "main"
        }
    }

    iosArm64()

    dependencies {
        //implementation("local.test.kgp:sample:1.0.0")
        implementation(project(":sample"))
    }
}

