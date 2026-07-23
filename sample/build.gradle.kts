plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    linuxX64()
    macosArm64()

    dependencies {
        implementation(files("libs/foo.kar", "libs/foo.kar.xz"))
    }
}

