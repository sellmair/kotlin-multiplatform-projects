allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}

plugins {
    kotlin("multiplatform") version "1.6.10" apply false
    kotlin("android") version "1.6.10" apply false
    id("com.android.application") apply false
}

/*

configurations.matching { it.name == "kotlinKlibCommonizerClasspath" }.all {
    attributes.attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
    attributes.attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.LIBRARY))

}

 */
