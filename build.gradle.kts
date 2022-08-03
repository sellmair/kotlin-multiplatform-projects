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


    flavorDimensions += listOf("price", "market")

    productFlavors {
        create("free") {
            dimension = "price"
        }
        create("paid") {
            dimension = "price"
        }
        create("eu") {
            dimension = "market"
        }
        create("us") {
            dimension = "market"
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

    val commonMain by sourceSets.getting
    val commonTest by sourceSets.getting

    val androidMain by sourceSets.getting

    /*
    val androidUnitTest by sourceSets.getting
    val androidInstrumentedTest by sourceSets.getting

    commonTest.dependencies {
        implementation(kotlin("test-junit"))
    }

    androidUnitTest.dependencies {
        implementation("org.robolectric:robolectric:4.8")
        implementation("androidx.test:core:1.4.0")
        implementation("androidx.test:core-ktx:1.4.0")
    }

    androidInstrumentedTest.dependencies {
        implementation("androidx.test:runner:1.4.0")
        implementation("androidx.test:rules:1.4.0")
    }

     */
}
