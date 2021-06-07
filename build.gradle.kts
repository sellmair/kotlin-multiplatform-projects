import org.jetbrains.kotlin.gradle.plugin.sources.DefaultKotlinSourceSet

plugins {
    kotlin("multiplatform")
}

repositories {
    mavenLocal()
    mavenCentral()
}

val integrationTestTask = tasks.create("checkPlatformDependencies")

fun createPlatformDependenciesTestTask(sourceSet: DefaultKotlinSourceSet) {
    tasks.create("check${sourceSet.name.capitalize()}PlatformDependencies") {
        integrationTestTask.dependsOn(this)

        // Dependencies forwarded to the IDE will be attached to the intransitiveMetadataConfiguration
        val dependenciesConfiguration = configurations.getByName(sourceSet.intransitiveMetadataConfigurationName)
        dependsOn("commonize")

        doLast {
            val dependencies = dependenciesConfiguration.files

            dependencies.forEach { dependency ->
                logger.quiet("${sourceSet.name} dependency: ${dependency.path}")
            }

            if (dependencies.isEmpty()) {
                throw AssertionError("${sourceSet.name}: Expected at least one platform dependency")
            }

            if (dependencies.none { dependency -> "/klib/platform/" in dependency.path }) {
                throw AssertionError("${sourceSet.name}: Expected at least one dependency from '/klib/platform'")
            }

            dependencies.forEach { dependency ->
                if ("/klib/commonized" in dependency.path) {
                    throw AssertionError(
                        "${sourceSet.name}: Found unexpected commonized dependency ${dependency.path}"
                    )
                }
            }
        }
    }
}

kotlin {
    linuxX64()
    linuxArm64()

    createPlatformDependenciesTestTask(sourceSets.getByName("linuxX64Main") as DefaultKotlinSourceSet)
    createPlatformDependenciesTestTask(sourceSets.getByName("linuxArm64Main") as DefaultKotlinSourceSet)
}
