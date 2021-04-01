import kotlinx.cinterop.pointed
import kotlinx.cinterop.useContents

fun iosMain() {
    withPosix.helloFromNative()
    withPosix.getFileStat().useContents { this }
    withPosix.createMyStruct().useContents {

    }
}
