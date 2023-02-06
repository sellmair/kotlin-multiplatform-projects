plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation(kotlin("gradle-plugin:1.9.255-SNAPSHOT"))
}