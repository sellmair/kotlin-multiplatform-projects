pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.android")) {
                useModule("com.android.tools.build:gradle:7.0.0")
                //useModule("com.android.tools.build:gradle:4.2.0")
            }
        }
    }
}

rootProject.name = "mpp-issue-bootstrap"
include(":multiplatform")
//include(":kpm")
//include(":kpm-library")
//include(":android-consumer")

