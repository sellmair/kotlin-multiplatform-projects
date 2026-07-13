package sample

actual fun printNativeCoroutinePlatform(coroutineId: Int) {
    println("Coroutine $coroutineId passed through appleMain")
    printAppleCoroutinePlatform(coroutineId)
}

expect fun printAppleCoroutinePlatform(coroutineId: Int)
