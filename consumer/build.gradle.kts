@file:Suppress("HasPlatformType", "UnstableApiUsage")

import org.gradle.kotlin.dsl.support.serviceOf

plugins {
    `maven-publish`
}

group = "org.jetbrains.sample"

/**
 * IMPORTANT NOTE:
 * The version used for publishing the root/repository was 1.0.0 and therefore higher.
 * The issue does only occur if the version used here is **lower** than what was published in the repository.
 */
version = "0.5.0"   // FAIL!
//version = "1.0.0" // OK
//version = "1.1.0" // OK


val implementation by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
    attributes { attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_API)) }
}

val apiElements by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = false
    attributes { attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_API)) }
    extendsFrom(implementation)
}

dependencies {
    implementation(project(":producer"))

    /**
     * IMPORTANT NOTE:
     * An arbitrary dependency (here kotlinx-coroutines-core) was added to the publication.
     * The issue can be reproduced w/ or w/o uncommenting the following line.
     */
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1") // only for publishing
}


//region How publication was build
val apiComponent = serviceOf<SoftwareComponentFactory>().adhoc("api")
apiComponent.addVariantsFromConfiguration(apiElements) {}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(apiComponent)
        }
    }

    repositories {
        maven(rootProject.file("repo"))
    }
}
//endregion


/**
 * IMPORTANT NOTE:
 * There are two kind of bad behaviours noticeable.
 * When the following configuration is used as 'dependency consistency scope' (shouldResolveConsistentlyWith),
 * then dependency resolution fails hard with
 * ```
 * * What went wrong:
 * Execution failed for task ':consumer:reproduceIssue'.
 * > Could not resolve all files for configuration ':consumer:implementation'.
 *    > Could not find org.jetbrains.kotlinx:kotlinx-coroutines-core:.
 *      Required by:
 *          project :consumer > org.jetbrains.sample:consumer:1.0.0
 *
 * * Try:
 * ```
 *
 * If the line
 *  `implementation.shouldResolveConsistentlyWith(implementationConsistencyScope)`
 * is commented out, then dependency resolution works, but un-intuitively resolves kotlinx-coroutines, while
 * also replacing the 'org.jetbrains.sample:consumer' dependency with this project dependency
 */
val implementationConsistencyScope by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
    attributes { attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_API)) }
    extendsFrom(implementation)
}

implementation.shouldResolveConsistentlyWith(implementationConsistencyScope)

tasks.register("reproduceIssue") {
    doFirst {
        println("All dependencies")
        implementation.incoming.resolutionResult.allDependencies.toList()
            .forEach { println(it.toString()) }

        println()
        println("Unresolved dependencies")
        implementation.resolvedConfiguration.lenientConfiguration.unresolvedModuleDependencies
            .forEach { println(it.toString()) }

        println()
        println("Resolved dependencies")
        implementation.resolvedConfiguration.lenientConfiguration.allModuleDependencies
            .forEach { println(it.toString()) }

        println()
        println("Resolved files: ")
        implementation.resolve().map { println(it.path) }

    }
}
