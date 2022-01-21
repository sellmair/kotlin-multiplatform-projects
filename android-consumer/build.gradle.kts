plugins {
    id("com.android.application")
    kotlin("android")
}

repositories {
    maven(project(":kpm").buildDir.resolve("repo"))
}

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 30
    }
}

dependencies {
    //implementation("kpm-android-external:kpm:1.0")
    implementation(project(":kpm"))
}

tasks.register("configurations") {
    doLast {
        configurations.forEach {
            logger.quiet(it.name)
        }
    }
}

tasks.register("peekDebugCompileClasspath") {
    doLast {
        configurations.getByName("debugCompileClasspath").attributes.apply {
            keySet().forEach { key ->
                logger.quiet("$key: ${this.getAttribute(key)}")
            }
        }
    }
}
