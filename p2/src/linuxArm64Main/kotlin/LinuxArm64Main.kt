import kotlinx.cinterop.useContents

fun linuxArm64Main() {
    createMyStructFromNativeMain().notAvailableOnMacos
    withPosix.helloFromNative()
    withPosix.getFileStat().useContents { this }
}
