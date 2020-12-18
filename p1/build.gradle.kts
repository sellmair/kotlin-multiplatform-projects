plugins {
    kotlin("interop-bundle")
    `maven-publish`
}

group = "org.jetbrains.kotlin"
version = "1.0.0"

dependencies {
    macos_x64(files("libs/macos_x64/curl.klib"))
    linux_x64(files("libs/linux_x64/curl.klib"))
}
