plugins {
    kotlin("multiplatform")
}


kotlin {
    linuxX64()

    sourceSets.commonMain.dependencies {
        implementation(project(":p2"))
    }
}
