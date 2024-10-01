plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlinx.benchmark")
}


kotlin {
    jvmToolchain(17)

    val main = target.compilations.getByName("main")
    val serviceLoader = target.compilations.create("serviceLoader")
    val methodInvoke = target.compilations.create("methodInvoke")

    main.defaultSourceSet.kotlin.srcDir("src/common/kotlin")
    serviceLoader.defaultSourceSet.kotlin.srcDir("src/common/kotlin")
    methodInvoke.defaultSourceSet.kotlin.srcDir("src/common/kotlin")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.12")
    "serviceLoaderImplementation"("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.12")
    "methodInvokeImplementation"("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.12")

    "serviceLoaderImplementation"("org.jetbrains.kotlin:kotlin-stdlib") {
        version { strictly("2.0.20-serviceLoader") }
    }

    "methodInvokeImplementation"("org.jetbrains.kotlin:kotlin-stdlib") {
        version { strictly("2.0.20-methodInvoke") }
    }
}

benchmark {
    targets.create("main")
    targets.create("serviceLoader")
    targets.create("methodInvoke")
}

