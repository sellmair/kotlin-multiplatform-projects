plugins {
    kotlin("jvm") version "2.3.0"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("test-junit5"))
}
