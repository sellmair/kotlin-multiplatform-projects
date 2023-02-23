object CommonMain {
    fun sayHello() = Unit
}

expect class ExpectClassInCommonMain {
    fun myFunction(): Int
}

expect fun expectInCommonMain(): Unit