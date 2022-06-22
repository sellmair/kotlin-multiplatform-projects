plugins {
    kotlin("multiplatform")
    `maven-publish`
}

version = "1.0"
group = "org.jetbrains"

val repo1 = buildDir.resolve("repo1")
val repo2 = buildDir.resolve("repo2")

publishing {
    repositories {
        maven(repo1) { name = "repo1" }
        maven(repo2) { name = "repo2" }
    }
}

tasks.register<Exec>("checkBuildConsistency") {
    doFirst {
        if (!repo1.resolve("org/jetbrains").exists()) {
            throw IllegalStateException("Missing repo1")
        }

        if (!repo2.resolve("org/jetbrains").exists()) {
            throw IllegalStateException("Missing repo2")
        }
    }

    commandLine(
        "diff", repo1.absolutePath, repo2.absolutePath, "-r", "-x", "maven-metadata**"
    )
}

kotlin {
    jvm()
    linuxX64()
    linuxArm64()

    val commonMain by sourceSets.getting
    val linuxX64Main by sourceSets.getting
    val linuxArm64Main by sourceSets.getting
    val nativeMain by sourceSets.creating

    nativeMain.dependsOn(commonMain)
    linuxX64Main.dependsOn(nativeMain)
    linuxArm64Main.dependsOn(nativeMain)
}
