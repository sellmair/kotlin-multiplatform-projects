plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    sourceSets {
        getByName("commonTest") {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}
