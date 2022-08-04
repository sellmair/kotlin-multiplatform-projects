@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.plugin.ExperimentalKotlinGradlePluginApi

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}


android {
    compileSdk = 31
    defaultConfig {
        minSdk = 31
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    android.flavorDimensions.add("market")
    android.flavorDimensions.add("price")
    android.productFlavors.create("german").dimension = "market"
    android.productFlavors.create("usa").dimension = "market"
    android.productFlavors.create("paid").dimension = "price"
    android.productFlavors.create("free").dimension = "price"
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

kotlin {
    android()
    jvm()

    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting
    val androidMain by sourceSets.getting
    val androidTest by sourceSets.getting
    val androidAndroidTest by sourceSets.getting

    commonTest.dependencies {
        implementation(kotlin("test-junit"))
    }

    androidTest.dependencies {
        implementation("org.robolectric:robolectric:4.8")
        implementation("androidx.test:core:1.4.0")
        implementation("androidx.test:core-ktx:1.4.0")
    }

    androidAndroidTest.dependencies {
        implementation("androidx.test:runner:1.4.0")
        implementation("androidx.test:rules:1.4.0")
    }

    sourceSets.invokeWhenCreated("androidTestGermanFreeDebug") {
        dependencies {
            implementation("com.squareup.okio:okio:3.2.0")
        }
    }
}

tasks.create("printAndroidSourceSetNames") {
    doLast {
        android.libraryVariants.all {
            logger.quiet(name)
            logger.quiet(sourceSets.map { it.name }.toString())
            logger.quiet("\n")
        }
    }
}

tasks.create("printKotlinSourceSetNames") {
    doLast {
        kotlin.android().compilations.forEach {
            logger.quiet("${it.compilationName} -> ${it.defaultSourceSetName}")
        }
    }
}