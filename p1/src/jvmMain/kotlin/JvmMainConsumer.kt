import io.sellmair.CommonMainApi
import io.sellmair.JvmMainApi

class JvmMainConsumer : CommonMainConsumer(), CommonMainApi, JvmMainApi

fun main() {
    JvmMainConsumer()
}
