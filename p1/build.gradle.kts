plugins {
    kotlin("multiplatform")
}

kotlin {
    sourceSets.all {
        languageSettings.languageVersion = "2.0"
    }

    jvm()
}