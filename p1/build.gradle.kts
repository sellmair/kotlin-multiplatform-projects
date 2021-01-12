@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform")
}

kotlin {
    val jvm = jvm()
    val js = js {
        nodejs()
    }

    val commonMain = sourceSets.getByName("commonMain")
    commonMain.dependencies {
        implementation("io.sellmair.KTIJ-737:p2:1.5.255-SNAPSHOT")
    }
}
