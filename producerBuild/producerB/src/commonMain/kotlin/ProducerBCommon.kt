import com.arkivanov.mvikotlin.core.store.Store
import okio.Path
import okio.Path.Companion.toPath

object ProducerBCommon {
    fun useOkio(): Path = "".toPath()
    fun useMviKotlin(): Store<Any, Any, Any> = TODO()
}
