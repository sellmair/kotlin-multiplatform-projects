plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    linuxX64() // <- Any second target required to make 'commonMain' actually common.
}