@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform")
}

repositories {
    maven("https://dl.bintray.com/sellmair/testing")
}

kotlin {
    val jvm = jvm()
    val js = js {
        nodejs()
    }

    val commonMain = sourceSets.getByName("commonMain")
    commonMain.dependencies {
        implementation("io.sellmair.KTIJ-737:p2:1.0.1")
    }
}
