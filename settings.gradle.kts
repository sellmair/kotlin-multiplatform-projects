pluginManagement {
    repositories {
        mavenLocal()
        maven("https://cache-redirector.jetbrains.com/repo.maven.apache.org/maven2/")
        maven("https://cache-redirector.jetbrains.com/dl.google.com.android.maven2/")
        maven("https://cache-redirector.jetbrains.com/plugins.gradle.org/m2/")
        maven("https://cache-redirector.jetbrains.com/maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
    plugins {
        kotlin("multiplatform") version "1.6.21"
        kotlin("android") version "1.6.21"
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.0.4")
            }
        }
    }
}

include(":p1")
include(":p2")
