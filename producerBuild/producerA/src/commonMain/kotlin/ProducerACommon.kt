import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import okio.Path
import okio.Path.Companion.toPath

object ProducerACommon {
    fun useOkio(): Path = "".toPath()
    fun useMviKotlin(): Store<Any, Any, Any> = TODO()
}
