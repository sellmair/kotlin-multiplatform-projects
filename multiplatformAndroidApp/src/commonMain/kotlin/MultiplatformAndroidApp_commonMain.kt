import okio.Path.Companion.toPath

object MultiplatformAndroidApp_commonMain {
    fun sayHello() {
        "some/path/".toPath()
        MultiplatformAndroidJvmIosLibrary_commonMain.sayHello()
        MultiplatformAndroidJvmIosLibrary_androidAndJvmMain.sayHello()

        MultiplatformJvmLibrary_commonMain.sayHello()
        MultiplatformJvmLibrary_jvmMain.sayHello()

        MultiplatformAndroidLibrary_commonMain.sayHello()
        //MultiplatformAndroidLibrary_androidMain.sayHello() <- would be nice to resolve!

        JvmLibrary_main.sayHello()
    }
}
