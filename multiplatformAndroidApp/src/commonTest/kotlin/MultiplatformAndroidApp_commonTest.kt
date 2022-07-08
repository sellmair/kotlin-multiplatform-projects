import okio.Path.Companion.toPath

object MultiplatformAndroidApp_commonTest {
    fun sayHello() {
        "some/path/".toPath()

        MultiplatformAndroidJvmIosLibrary_commonMain.sayHello() // unresolved; !bug in single android target case
        MultiplatformAndroidJvmIosLibrary_androidAndJvmMain.sayHello() // unresolved; !bug in single android target case
        //MultiplatformAndroidJvmIosLibrary_androidMain.sayHello() // unresolved; would be desirable

        MultiplatformJvmLibrary_commonMain.sayHello()
        MultiplatformJvmLibrary_jvmMain.sayHello()

        MultiplatformAndroidLibrary_commonMain.sayHello() // // unresolved; !bug in single android target case
        //MultiplatformAndroidLibrary_androidMain.sayHello() // unresolved; would be desirable
    }
}
