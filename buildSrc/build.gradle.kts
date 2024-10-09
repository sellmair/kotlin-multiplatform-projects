plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(kotlin("gradle-plugin:2.0.20"))
    compileOnly("com.android.tools.build:gradle:8.5.2")
}
