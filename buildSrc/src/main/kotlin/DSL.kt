@DslMarker
annotation class MyDsl

@MyDsl
class A {
    fun a() = Unit
    fun b(configure: B.() -> Unit) = Unit
}

@MyDsl
class B {
    fun b() = Unit
}
