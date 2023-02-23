object JvmMain {
    init {
        CommonMain.sayHello()
        ExpectClassInCommonMain().myFunction()
    }
}

actual fun expectInCommonMain() = Unit

actual class ExpectClassInCommonMain {
    actual fun myFunction(): Int = 1
}