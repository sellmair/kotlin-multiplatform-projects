import io.ktor.client.*
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

    fun useAtomicFu() {
        atomic
    }
}
