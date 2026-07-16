plugins {
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    maven(file("../local-maven-repo"))
    maven(file("/Users/Sebastian.Sellmair/JetBrainsProjects/kotlinx.coroutines/build/build-local-repository"))

    mavenCentral()
    mavenLocal()
    maven("https://packages.jetbrains.team/maven/p/kt/dev")

}

dependencies {
    implementation("local.test.kgp:sample:1.0.0")
    //implementation(project(":sample"))
}
