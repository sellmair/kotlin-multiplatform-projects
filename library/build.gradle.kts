plugins {
    kotlin("jvm")
    `maven-publish`
}

group = "org.jetbrains.kotlin"
version = "1.0.0"

publishing {
    repositories {
        maven(file("repository"))
    }

    publications {
        create<MavenPublication>("main") {
            from(components["java"])
        }
    }
}