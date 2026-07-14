import foo.x
import kotlinx.cinterop.ExperimentalForeignApi

fun nativeMainConsumer() {
    sample.nativeMain()
}

fun useCInterop() {
    @OptIn(ExperimentalForeignApi::class)
    x()
}