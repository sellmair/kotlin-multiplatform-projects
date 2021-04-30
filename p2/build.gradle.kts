plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    js { browser() }

    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":p1"))
                implementation(kotlin("stdlib-common"))
            }
        }

        val jvmAndJsMain by creating {
            dependsOn(commonMain)
        }

        val jvmMain by getting {
            dependsOn(jvmAndJsMain)
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }

        val jsMain by getting {
            dependsOn(jvmAndJsMain)
            dependencies {
                implementation(kotlin("stdlib-js"))
            }
        }
    }
}