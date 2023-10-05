plugins {
    kotlin("jvm")
    `maven-publish`
}

group = "org.jetbrains.sample"
version = "1.0.0-SNAPSHOT"

publishing {
    repositories {
        maven(file(rootDir.resolve("repo")))
    }

    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

kotlin {
    jvmToolchain(11)
}
