rootProject.name = "test-kgp"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/kt/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://packages.jetbrains.team/maven/p/kt/dev")
    }
}

include(":sample")
include(":consumer")