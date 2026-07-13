package sample

actual fun printAppleCoroutinePlatform(coroutineId: Int) {
    println("Coroutine $coroutineId is running on iOS")
}
