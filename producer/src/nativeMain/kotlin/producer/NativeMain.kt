package producer

actual class Producer {
    actual fun foo(value: String, optionalParameter: Boolean) = Unit
}

fun inProducerNativeMain() {
   Producer().foo("") // <-  No value passed for parameter 'optionalParameter'
}