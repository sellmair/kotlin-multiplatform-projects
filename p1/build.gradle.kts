import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    compileSdk = 33
}

kotlin {
    jvm()
    android()
}

val myCodeGenerationTask = tasks.register("generateCodeOnImport") {
    doLast {
        file("src/commonMain/kotlin/Generated.kt")
            .apply { parentFile.mkdirs() }
            .writeText("object Generated")
    }
}

tasks.maybeCreate("prepareKotlinIdeaImport")
    .dependsOn(myCodeGenerationTask) // <- 'generateCodeOnImport' will now run automatically on Gradle Sync