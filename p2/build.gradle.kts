@file:Suppress("UNUSED_VARIABLE")

import com.jfrog.bintray.gradle.tasks.BintrayUploadTask

plugins {
    kotlin("multiplatform")
    `maven-publish`
    id("com.jfrog.bintray")
}

group = "io.sellmair.KTIJ-737"
version = "1.0.4"

kotlin {
    val jvm = jvm()
    val js = js().nodejs()

    val commonMain = sourceSets.getByName("commonMain")
    val jvmAndJsMain = sourceSets.create("jvmAndJsMain")
    val jvmMain by sourceSets.getting
    val jsMain by sourceSets.getting

    jvmAndJsMain.dependsOn(commonMain)
    jvmMain.dependsOn(jvmAndJsMain)
    jsMain.dependsOn(jvmAndJsMain)
}

bintray {
    user = properties["bintray.user.sellmair"].toString()
    key = properties["bintray.key.sellmair"].toString()

    pkg.run {
        repo = "testing"
        name = "ktij-737-p2"
        vcsUrl = "https://github.com/sellmair/mpp-issue-bootstrap"
        setLicenses("Apache-2.0")
        setPublications("kotlinMultiplatform", "js", "jvm", "jvmAndJs")
    }
}


tasks.withType<BintrayUploadTask> {
    doFirst {
        publishing.publications
            .filterIsInstance<MavenPublication>()
            .forEach { publication ->
                val moduleFile = buildDir.resolve("publications/${publication.name}/module.json")
                if (moduleFile.exists()) {
                    publication.artifact(object : org.gradle.api.publish.maven.internal.artifact.FileBasedMavenArtifact(moduleFile) {
                        override fun getDefaultExtension() = "module"
                    })
                }
            }
    }
}
