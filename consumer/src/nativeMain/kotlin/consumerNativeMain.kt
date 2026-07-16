import foo.x
import kotlinx.cinterop.ExperimentalForeignApi

fun nativeMainConsumer() {
    sample.nativeMain()
    useCInterop()
}

@OptIn(ExperimentalForeignApi::class)
fun useCInterop() {
    x()
}
@OptIn(ExperimentalForeignApi::class)
fun main() {
    println(x())
    println("We called x()!!")
}



