import kotlinx.cinterop.useContents
import platform.posix.fopen
import withPosix.MyStruct

fun linuxMain() {
    fopen("juhu.txt", "rw")
    withPosix.helloFromNative()
    withPosix.getFileStat().useContents { this }
    doSomething(createMyStructFromNativeMain())
    createMyStructFromNativeMain().notAvailableOnMacos
    val x = createMyStructFromNativeMain()
}

fun doSomething(myStruct: MyStruct) {
    myStruct.availableOnAllPlatforms
}
