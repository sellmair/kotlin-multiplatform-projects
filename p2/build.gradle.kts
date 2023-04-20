plugins {
    kotlin("jvm")
}

kotlin.sourceSets.all {
    languageSettings.optIn("MyOptIn")
}

dependencies {
    implementation(project(":p1"))
}