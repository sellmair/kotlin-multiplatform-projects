plugins {
    kotlin("multiplatform")
}


kotlin {
    val macos = macosX64("macos")
    val linux = linuxX64("linux")

    // c interop
    listOf(macos, linux).forEach { target ->
        val curl = target.compilations.getByName("main").cinterops.create("curl")
        curl.defFile = file("interop/libcurl.def")
    }
    //
}
