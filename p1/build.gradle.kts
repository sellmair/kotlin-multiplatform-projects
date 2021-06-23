
plugins {
    kotlin("multiplatform")
    `maven-publish`
}

publishing {
    repositories {
        this.maven {
            this.name = "build"
            this.url = buildDir.resolve("repo").toURI()
        }
    }
}



kotlin {
    ios {
        compilations.getByName("main").cinterops.create("StarIO")
        binaries.framework()
    }
}
