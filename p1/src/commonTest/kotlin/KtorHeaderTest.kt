import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


@Serializable
data class SamplePayload(val id: Int = 0)

class KtorHeaderTest {

    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }


    @Test
    fun put(): Unit = runBlocking {
        val response = client.request<HttpResponse> {
            url("https://sellmair.io")
            method = HttpMethod.Put
            contentType(ContentType.Application.Json)
            body = SamplePayload(0)
        }

        assertTrue(response.request.headers.toMap().keys.contains("Content-Type"))
    }

    @Test
    fun get(): Unit = runBlocking {
        val response = client.request<HttpResponse>() {
            url("https://sellmair.io")
            contentType(ContentType.Application.Json) // even if nonsense
            header("Custom-Header", "MyCustomHeader")
        }

        val headers = response.request.headers.toMap()
        assertEquals(
            "MyCustomHeader", headers["Custom-Header"].orEmpty().single().toString()
        )
        assertEquals(
            "application/json", headers["Content-Type"].toString()
        )
    }
}
