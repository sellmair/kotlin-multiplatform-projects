plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    val commonMain by sourceSets.getting
    commonMain.dependencies {
        implementation("io.sellmair:p1:1-SNAPSHOT")
        //implementation(project(":p1"))
    }
}
