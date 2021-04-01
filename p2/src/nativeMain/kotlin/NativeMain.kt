import kotlinx.cinterop.pointed
import platform.posix.fopen
import withPosix.MyStruct
import withPosix.createMyStructPointer

fun main() {
    fopen("juhu.txt", "rw")
    withPosix.helloFromNative()
    withPosix.getFileStat()
    createMyStructFromNativeMain().availableOnAllPlatforms
    createMyStructFromNativeMain()
}

fun createMyStructFromNativeMain(): MyStruct {
    return createMyStructPointer()!!.pointed
}

