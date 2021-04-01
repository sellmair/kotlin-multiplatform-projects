import kotlinx.cinterop.pointed
import kotlinx.cinterop.useContents

fun darwinMain() {
    createMyStructFromNativeMain()
    withPosix.createMyStructPointer()!!.pointed
    withPosix.helloFromNative()
    withPosix.createMyStruct()
    withPosix.getFileStat().useContents { this }
}
