plugins {
    kotlin("multiplatform")
    id("com.android.library")
}


android {
    compileSdk = 31
    defaultConfig {
        minSdk = 31
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    flavorDimensions += listOf("price")
    //setFlavorDimensions(listOf("price"))

    productFlavors {
        create("free") {
            dimension = "price"
        }
        create("paid") {
            dimension = "price"
        }
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

kotlin {
    android()
    jvm()
    //iosX64()

    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting
    val androidMain by sourceSets.getting
//    val androidInstrumentedTest by sourceSets.getting
//    val androidUnitTest by sourceSets.getting

    commonMain.dependencies {
        implementation("com.squareup.okio:okio:3.2.0")
        implementation("com.russhwolf:multiplatform-settings:1.0.0-alpha01")
    }

    commonTest.dependencies {
        implementation(kotlin("test-junit"))
    }

    /*
    androidInstrumentedTest.dependencies {
        implementation("androidx.test:runner:1.4.0")
        implementation("androidx.test:rules:1.4.0")
    }
     */
}


tasks.register("debug") {
    doLast {
        android.sourceSets.forEach { println("AndroidSourceSet: ${it.name}") }
    }
}
