allprojects {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
}

subprojects {
    buildscript {
        repositories {
            mavenCentral()
            google()
            mavenLocal()
        }

        /*
        dependencies {
            classpath("org.jetbrains.kotlin:kotlin-gradle-external-target-api:1.6.255-SNAPSHOT@jar")
        }
         */
    }
}
