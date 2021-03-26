import kotlinx.cinterop.useContents

fun linuxArm64Main() {
    withPosix.helloFromNative()
    withPosix.getFileStat().useContents { score(this) }
}
