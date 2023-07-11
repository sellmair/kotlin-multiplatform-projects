plugins {
    kotlin("multiplatform")
}

repositories {
    maven(rootDir.resolve("repo"))
    mavenLocal()
    mavenCentral()
}

kotlin {
    jvm()

    sourceSets.commonMain.dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
    }

    sourceSets.jvmMain.dependencies {
        implementation("org.jetbrains.sample:p1:1.0.0")
        implementation("org.jetbrains.sample:p1:1.0.0:foo")
    }

    sourceSets.jvmTest.dependencies {
        implementation(project.dependencies.testFixtures("org.jetbrains.sample:p1:1.0.0"))
    }

}
