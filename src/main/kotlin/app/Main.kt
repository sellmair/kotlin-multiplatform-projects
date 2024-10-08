package app

import kotlinx.coroutines.*
import kotlinx.coroutines.external.StaticDebugProbes

class A

fun main() {
    runBlocking {
        launch {
            StaticDebugProbes.print()
            delay(1000)
            withContext(Dispatchers.IO) {

            }
        }
    }
    println("Finished.")
    StaticDebugProbes.print()
}