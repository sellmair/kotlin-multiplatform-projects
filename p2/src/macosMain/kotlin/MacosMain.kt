import kotlinx.cinterop.useContents

fun linuxMain() {
    createMyStructFromNativeMain()
    withPosix.helloFromNative()
    withPosix.getFileStat().useContents { this }
}
