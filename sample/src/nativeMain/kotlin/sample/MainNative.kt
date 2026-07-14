package sample

import foo.x
import kotlinx.cinterop.ExperimentalForeignApi

fun nativeMain() {
    @OptIn(ExperimentalForeignApi::class)
    x()
}

actual fun printCoroutinePlatform(coroutineId: Int) {
    println("Coroutine $coroutineId passed through nativeMain")
    printNativeCoroutinePlatform(coroutineId)
}

expect fun printNativeCoroutinePlatform(coroutineId: Int)
