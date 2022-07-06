import okio.Path.Companion.toPath

object MultiplatformAndroidLibrary_commonMain {
    fun sayHello() {
        "path/to/file".toPath()
        println("Hello")
    }
}