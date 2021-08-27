plugins {
    kotlin("multiplatform")
}

kotlin {
    macosX64()
    ios()

    val commonTest by sourceSets.getting
    
    commonTest.dependencies {
        implementation("io.mockk:mockk:1.11.0") // <-- MOCKK is not available for ios or macos!
    }
}