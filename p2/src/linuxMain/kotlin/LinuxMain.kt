import kotlinx.cinterop.useContents
import platform.posix.fopen

fun linuxMain() {
    fopen("juhu.txt", "rw")
    withPosix.helloFromNative()
    withPosix.getFileStat().useContents { score(this) }
}
