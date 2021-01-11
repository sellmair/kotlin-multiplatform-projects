@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

group = "io.sellmair.KTIJ-737"
version = "1.0-SNAPSHOT"

kotlin {
    val jvm = jvm()
    val js = js {
        nodejs()
    }
}
