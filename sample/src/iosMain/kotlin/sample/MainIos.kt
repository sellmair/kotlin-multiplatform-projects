package sample

import kotlinx.coroutines.CloseableCoroutineDispatcher

actual fun printAppleCoroutinePlatform(coroutineId: Int) {
    println("Coroutine $coroutineId is running on iOS")
}
