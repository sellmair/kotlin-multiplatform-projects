allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
}

tasks.register<Delete>("clean") {
    delete(buildDir)
}
