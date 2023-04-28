plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()

    sourceSets.commonMain.get().dependencies {
        implementation(project(":p2"))
    }
}