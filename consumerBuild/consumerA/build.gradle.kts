@file:Suppress("OPT_IN_USAGE")

plugins {
    kotlin("multiplatform")
}

tasks.named("prepareKotlinIdeaImport").configure {
    dependsOn(gradle.includedBuilds.map { it.task(":producerA:prepareKotlinIdeaImport") })
    dependsOn(gradle.includedBuilds.map { it.task(":producerB:prepareKotlinIdeaImport") })
    dependsOn(gradle.includedBuilds.map { it.task(":producerC:prepareKotlinIdeaImport") })
}

kotlin {
    targetHierarchy.default()
    jvm()
    linuxX64()
    iosX64()
    iosArm64()

    sourceSets.commonMain.get().dependencies {
        implementation("org.jetbrains.sample:producerA:1.0.0-SNAPSHOT")
    }
}