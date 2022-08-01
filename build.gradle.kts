import ru.vyarus.gradle.plugin.animalsniffer.AnimalSniffer
import ru.vyarus.gradle.plugin.animalsniffer.AnimalSnifferExtension

plugins {
    kotlin("multiplatform")
    `maven-publish`
    id("ru.vyarus.animalsniffer") version "1.5.4"
}

group = "org.jetbrains"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        /* To support animalsniffer */
        withJava()
    }
}

/* Setup animalsniffer */
run {
    val signature by configurations
    dependencies {
        signature("net.sf.androidscents.signature:android-api-level-14:4.0_r4@signature")
        signature("org.codehaus.mojo.signature:java17:1.0@signature")
    }

    configure<AnimalSnifferExtension> {
        sourceSets = listOf(project.sourceSets.getByName("main"))
    }

    tasks.withType<AnimalSniffer>().configureEach {
        exclude("**/jdk8/*")
    }
}

/* Setup publishing to local build dir to check publications */
publishing {
    repositories {
        maven(file("build/repo")) { name = "build" }
    }
}

/* Setup jvm16 only sources compilation */
/*
             [DEPENDS ON EDGES]

                commonMain
                     |
                     |
                  jvmMain
                  /    \
                /       \
             jvm16Main   jvm18Main

jvmMain compilation:    [commonMain, jvmMain, jvm16Main, jvm18Main]
jvm16Main compilation:  [commonMain, jvmMain, jvm16Main]

animalsniffer: run's against jvmMain compilation. Ignores sources in jdk8 package
 */
kotlin {
    val jvmMain by sourceSets.getting

    val jvm16Main = sourceSets.create("jvm16Main")
    val jvm18Main = sourceSets.create("jvm18Main")

    jvm16Main.dependsOn(jvmMain)
    jvm18Main.dependsOn(jvmMain)


    jvm {
        compilations.getByName("main").apply {
            source(jvm16Main)
            source(jvm18Main)
        }

        /* Create compilation for jvm16Main to prove that jvmMain does not rely on jvm18Main */
        compilations.create("16Main") {
            /* jvm16Main is automatically matched as 'defaultSourceSet' for the compilation */
            tasks.getByName("check")
                .dependsOn(this.compileKotlinTaskProvider)
        }
    }
}
