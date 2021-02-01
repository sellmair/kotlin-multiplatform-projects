/**
 * INTEROP BUNDLE PRODUCER (p1)
 */

plugins {
    kotlin("interop-bundle")
    `maven-publish`
}

interopBundle {
    groupId.set("io.sellmair")
    artifactId.set("libcurl")
    version.set("7.64.1-kib0")
}

dependencies {
    macos_x64(files("libs/macos_x64/curl.klib"))
    linux_x64(files("libs/linux_x64/curl.klib"))
}

