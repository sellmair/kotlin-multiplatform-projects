package sample

actual fun printNativeCoroutinePlatform(coroutineId: Int) {
    println("Coroutine $coroutineId is running on Linux X64")
}
