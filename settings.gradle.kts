include("producer")
include("consumer")

dependencyResolutionManagement {
    repositories {
        maven(rootDir.resolve("repository"))
        mavenCentral()
    }
}
