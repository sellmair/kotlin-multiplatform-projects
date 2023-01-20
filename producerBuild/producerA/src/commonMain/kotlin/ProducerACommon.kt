
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import okio.Path
import okio.Path.Companion.toPath

object ProducerACommon {
    fun useCoroutines(): Deferred<Unit> = CompletableDeferred(Unit)
    fun useOkio(): Path = "".toPath()
}
