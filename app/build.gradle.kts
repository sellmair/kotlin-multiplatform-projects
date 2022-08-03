plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
    maven(rootProject.file("library/repository"))
}

dependencies {
    implementation("org.jetbrains.kotlin:library:1.0.0")
    testImplementation("org.jetbrains.kotlin:library:2.0.0")
}