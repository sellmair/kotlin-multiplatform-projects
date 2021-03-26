import kotlinx.cinterop.useContents

fun linuxX64Main() {
    withPosix.helloFromNative()
    withPosix.getFileStat().useContents { score(this) }
}
