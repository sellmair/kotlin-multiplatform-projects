import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

fun useCoroutines() {
    runBlocking(Dispatchers.IO) {
        //
    }
}
