import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

kotlin {
    iosArm64()
    iosX64()
    linuxX64()

    targetHierarchy.default()

    sourceSets.commonMain.get().dependencies {
        api("co.touchlab:sqliter-driver:1.2.1")
    }

    targets.withType<KotlinNativeTarget>().all {
        compilations.getByName("main").cinterops.create("dummy") {
            header("src/dummy.h")
        }
    }
}
