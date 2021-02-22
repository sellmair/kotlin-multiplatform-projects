import io.ktor.client.*
import kotlinx.atomicfu.*
import kotlinx.coroutines.*

interface CommonMain {
    fun useKtorApis(): HttpClient {
        return HttpClient {
            this.developmentMode = true
            this.expectSuccess  = true
        }.config {
            this.useDefaultTransformers = true
        }
    }

    fun useCoroutinesApis(): Deferred<String> {
        return GlobalScope.async(Dispatchers.Main) {
            withContext(Dispatchers.Default) {
                "This code is abusing coroutines! 🤷"
            }
        }
    }

    fun useAtomicFu(): AtomicInt {
        return atomic(0)
    }


    /* TODO NOW: Should not be visible */
    fun androidSdkIsNotVisible(context: android.content.Context) {

    }
}
