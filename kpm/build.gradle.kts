import org.jetbrains.kotlin.gradle.android.android
import org.jetbrains.kotlin.gradle.android.androidCommon
import org.jetbrains.kotlin.gradle.android.instrumentedTest
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.jvm

plugins {
    kotlin("multiplatform.pm20")
    //id("com.android.application")
    id("com.android.library")
    id("kotlin-kpm-android")
    `maven-publish`
}

group = "kpm-android-external"
version = "1.0"

publishing {
    repositories {
        maven(buildDir.resolve("repo")) {
            name = "buildRepo"
        }
    }
}

android {
    compileSdk = 31
    defaultConfig {
        minSdk = 30
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("debug")
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

// TODO NOW
tasks.matching { it.name.matches(Regex("""compile.*Android.*Metadata""")) }.configureEach {
    enabled = false
}

kotlin {
    android()
    jvm { }

    mainAndTest {
        common.dependencies {
            implementation("com.arkivanov.mvikotlin:mvikotlin:3.0.0-beta01")
        }
    }

    main {
        fragments.create("someNewFragment")

        androidCommon.dependencies {
            implementation(kotlin("stdlib-jdk8"))
            implementation("androidx.appcompat:appcompat:1.4.0")
            //implementation("androidx.appcompat:appcompat:1.4.0")
        }
    }

    test {
        androidCommon.dependencies {
            implementation(kotlin("test-junit"))
            implementation("androidx.test:core:1.4.0")
            implementation("androidx.test:core-ktx:1.4.0")
            implementation("androidx.test.ext:junit:1.1.3")
            implementation("androidx.test.ext:junit-ktx:1.1.3")
        }
    }

    instrumentedTest {
        androidCommon.dependencies {
            implementation(kotlin("test-junit"))
            implementation("androidx.test:core:1.4.0")
            implementation("androidx.test:core-ktx:1.4.0")
            implementation("androidx.test:rules:1.4.0")
        }
    }
}
