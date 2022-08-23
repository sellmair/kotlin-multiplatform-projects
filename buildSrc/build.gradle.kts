plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.8.255-SNAPSHOT"))
}
