import kotlinx.cinterop.useContents

fun linuxMain() {
    withPosix.helloFromNative()
    withPosix.getFileStat().useContents { score(this) }
}
