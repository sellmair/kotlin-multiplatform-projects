package sample

actual fun printCoroutinePlatform(coroutineId: Int) {
    println("Coroutine $coroutineId is running on JVM")
}
