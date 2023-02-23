object NativeMain

actual fun expectInCommonMain() = Unit

actual class ExpectClassInCommonMain {
    actual fun myFunction(): Int = 1
}