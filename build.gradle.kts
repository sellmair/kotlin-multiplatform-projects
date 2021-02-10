allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
        jcenter()
    }
}

tasks.create<Delete>("clean") {
    delete(buildDir)
}
