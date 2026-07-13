package sample

actual fun printCoroutinePlatform(coroutineId: Int) {
    println("Coroutine $coroutineId passed through nativeMain")
    printNativeCoroutinePlatform(coroutineId)
}

expect fun printNativeCoroutinePlatform(coroutineId: Int)
