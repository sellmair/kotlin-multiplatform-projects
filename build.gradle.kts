plugins {
    kotlin("multiplatform")
}

repositories {
    mavenLocal()
    mavenCentral()
}

kotlin {
    jvm()
    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting

    commonMain.dependencies {
        implementation("com.squareup.okio:okio:3.1.0")
    }

    commonTest.dependencies {
        implementation(kotlin("test-junit"))
    }
}
