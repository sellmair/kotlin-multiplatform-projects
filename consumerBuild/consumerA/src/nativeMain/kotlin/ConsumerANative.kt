import kotlinx.cinterop.memScoped
import platform.posix.fopen

object ConsumerANative {
    init {
        memScoped {  }
        fopen("", "")
        ProducerANative
    }
}