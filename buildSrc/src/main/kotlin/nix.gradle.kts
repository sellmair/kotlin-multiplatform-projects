plugins {
    id("multiplatform")
}

@ToolingProperty.Scope("Kotlin Build Settings")
object KotlinSettings {
    @ToolingProperty.Value(
        value = "1.8.255",
        title = "Kotlin Version",
        description = "Version of the Kotlin Gradle Plugin / Kotlin Gradle Plugin used"
    )
    val kotlinVersion: String by annotation()

    @ToolingProperty.Value(
        value = "1.8",
        title = "Kotlin Language Version"
    )
    val languageVersion: String by annotation()


    @ToolingProperty.Values(
        values = [
            "com.squareup.okio:okio:3.2.0",
            "com.russhwolf:multiplatform-settings-datastore:1.0.0-RC"
        ],
        title = "Dependencies"
    )
    val commonMainDependencies: List<String> by annotation()
}


/*
 Pre-declare hierarchy and targets. Usually one convention plugin would declare the hiearchy, wheras
 another depending convention plugin would declare targets!
 */
kotlin {
    logger.quiet("kotlinVersion=$KotlinSettings.kotlinVersion")
    logger.quiet("languageVersion=$KotlinSettings.languageVersion")
    logger.quiet("commonMainDependencies=$KotlinSettings.commonMainDependencies")

    sourceSets.all {
        languageSettings {
            this.languageVersion = KotlinSettings.languageVersion
        }
    }

    val commonMain by sourceSets.getting
    commonMain.dependencies {
        KotlinSettings.commonMainDependencies.forEach { dependenyNotation ->
            implementation(dependenyNotation)
        }
    }

    /* Declare my targets */
    iosX64()
    iosArm64()
    jvm()
}
