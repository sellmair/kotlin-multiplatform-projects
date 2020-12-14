plugins {
    kotlin("multiplatform")
}



kotlin {
    val macos = macosX64("macos")
    val linux = linuxX64("linux")

    /*
    val commonizeCurl = tasks.create<DependencyCommonizerTask>("commonizeCurl") {
        addLibrary(macos, files("libs/macos_x64/curl.klib"))
        addLibrary(linux, files("libs/linux_x64/curl.klib"))
    }
     */

    val commonMain = sourceSets.getByName("commonMain")
    val nativeMain = sourceSets.create("nativeMain")
    val macosMain = sourceSets.getByName("macosMain")
    val linuxMain = sourceSets.getByName("linuxMain")

    nativeMain.dependsOn(commonMain)
    macosMain.dependsOn(nativeMain)
    linuxMain.dependsOn(nativeMain)

    commonMain.dependencies {
        implementation(kotlin("stdlib-common"))
    }

    nativeMain.dependencies {
    }

    macosMain.dependencies {
    }

    linuxMain.dependencies {
    }

    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.RequiresOptIn")
    }
}

//enableCommonization(setOf(MACOS_X64, LINUX_X64, IOS_ARM32))

abstract class MyTransformation : TransformAction<TransformParameters.None> {
    @get:InputArtifact
    abstract val inputArtifact: Provider<FileSystemLocation>
    override fun transform(output: TransformOutputs) {
        output.file("myfile").writeText("Hey there Delilah; if you work please break the Compilah")
    }
}

val toCommonize = Attribute.of("toCommonize", Boolean::class.javaObjectType)

val curlKotlinInteropBundle by configurations.creating {
    outgoing {
        attributes {
            attribute(toCommonize, true)
        }
    }

    isCanBeResolved = false
    isCanBeConsumed = true
}

configurations.all {
    afterEvaluate {
        if (this != curlKotlinInteropBundle) {
            attributes.attribute(toCommonize, false)
        }
    }
}

dependencies {
    registerTransform(MyTransformation::class.java) {
        from.attribute(toCommonize, true)
        to.attribute(toCommonize, false)
    }
}

dependencies {
    curlKotlinInteropBundle(files("libs/macos_x64/curl.klib", "libs/linux_x64/curl.klib"))
    "nativeMainImplementation"(project(project.path, curlKotlinInteropBundle.name))
}

