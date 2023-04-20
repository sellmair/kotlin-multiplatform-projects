import okio.Path
import okio.Path.Companion.toPath

@RequiresOptIn(level = RequiresOptIn.Level.ERROR)
annotation class MyOptIn

@MyOptIn
class MyP1Class {
    fun getPath(): Path = "".toPath()
}