plugins {
    kotlin("multiplatform") apply false
}


allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
        jcenter()
    }
}

project(":p2").tasks.configureEach {
    // 🤷‍ It's a demo. Who really cares?
    dependsOn(":p1:publishToMavenLocal")
}
