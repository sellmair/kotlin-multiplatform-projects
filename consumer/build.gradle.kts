plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

repositories {
    maven(file("../local-maven-repo"))
    mavenCentral()
    mavenLocal()
    maven("https://packages.jetbrains.team/maven/p/kt/dev")
}

kotlin {
    jvm()
    linuxX64()
    iosArm64()

    dependencies {
        implementation("local.test.kgp:sample:1.0.0")
    }
}

