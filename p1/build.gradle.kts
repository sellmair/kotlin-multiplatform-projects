@file:Suppress("UNUSED_VARIABLE")

plugins {
    kotlin("multiplatform")
}

kotlin {
    val jvm = jvm()
    val js = js().nodejs()

    val commonMain = sourceSets.getByName("commonMain")
    val jvmAndJsMain = sourceSets.create("jvmAndJsMain")
    val jvmMain by sourceSets.getting
    val jsMain by sourceSets.getting

    jvmAndJsMain.dependsOn(commonMain)
    jvmMain.dependsOn(jvmAndJsMain)
    jsMain.dependsOn(jvmAndJsMain)

    commonMain.dependencies {
        implementation("io.sellmair.KTIJ-737:p2:1.0.4")
    }
}
