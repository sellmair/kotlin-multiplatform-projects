buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }

    dependencies {
        classpath(kotlin("gradle-plugin-tcs-android:1.8.255-SNAPSHOT"))
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.255-SNAPSHOT")
        classpath("com.android.tools.build:gradle:7.3.0")
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}
