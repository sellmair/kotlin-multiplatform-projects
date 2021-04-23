plugins {
    kotlin("multiplatform") apply false
    id("com.android.library") apply false
    id("com.android.application") apply false
}

allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
        jcenter()
    }
}
