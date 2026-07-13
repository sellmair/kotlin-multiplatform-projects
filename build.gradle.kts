plugins {
    base
}

group = providers.gradleProperty("projectGroup").get()
version = providers.gradleProperty("projectVersion").get()

val cleanLocalMavenRepo = tasks.register<Delete>("cleanLocalMavenRepo") {
    group = "publishing"
    description = "Deletes the project-local Maven repository before publishing."
    delete(layout.projectDirectory.dir("local-maven-repo"))
}

val removeLocalMavenRepoChecksums = tasks.register("removeLocalMavenRepoChecksums") {
    group = "publishing"
    description = "Removes checksum sidecar files from the project-local Maven repository."
    doLast {
        delete(
            fileTree(layout.projectDirectory.dir("local-maven-repo")) {
                include("**/*.md5", "**/*.sha1", "**/*.sha256", "**/*.sha512")
            }
        )
    }
}

tasks.register("publish") {
    group = "publishing"
    description = "Publishes all sample module publications to the project-local Maven repository."
    dependsOn(cleanLocalMavenRepo)
    dependsOn(":sample:publishAllPublicationsToProjectLocalRepository")
    finalizedBy(removeLocalMavenRepoChecksums)
}

subprojects {
    pluginManager.withPlugin("maven-publish") {
        tasks.matching { it.name == "publishAllPublicationsToProjectLocalRepository" }.configureEach {
            finalizedBy(rootProject.tasks.named("removeLocalMavenRepoChecksums"))
        }
    }
}
