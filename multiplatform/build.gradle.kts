plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()

    /* Add dependency from this multiplatform jvm part to the 'jvm only' project */
    sourceSets.getByName("jvmMain").dependencies {
        implementation(project(":jvm"))
    }
}

/* Create application like run task */

tasks.register<JavaExec>("runJvm") {
    classpath(kotlin.jvm().compilations.getByName("main").output.allOutputs)
    classpath(kotlin.jvm().compilations.getByName("main").configurations.runtimeDependencyConfiguration)
    mainClass.set("JvmMainKt")
}