plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
}

dependencies {
    commonTestImplementation(kotlin("test"))
}
