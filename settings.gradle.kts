rootProject.name = "test-kgp"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/kt/dev")
        maven(file("/Users/Sebastian.Sellmair/JetBrainsProjects/kotlinx.coroutines/build/build-local-repository"))

    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/kt/dev")
        maven(file("/Users/Sebastian.Sellmair/JetBrainsProjects/kotlinx.coroutines/build/build-local-repository"))
    }
}

include(":sample")
include(":consumer")