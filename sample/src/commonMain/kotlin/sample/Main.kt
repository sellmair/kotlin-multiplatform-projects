package sample

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        (1..10).map { coroutineId ->
            launch {
                printCoroutinePlatform(coroutineId)
            }
        }.joinAll()
    }
}

expect fun printCoroutinePlatform(coroutineId: Int)
