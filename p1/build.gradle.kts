
plugins {
    kotlin("multiplatform")
    `maven-publish`
}

kotlin {
    ios {
        compilations.getByName("main").cinterops.create("StarIO")
        binaries.framework()
    }
}
