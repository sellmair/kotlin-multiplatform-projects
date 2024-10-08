import java.util.concurrent.locks.ReentrantLock

object JvmAndAndroidMain {
    fun useJdk() = ReentrantLock()
}

expect fun differentJvmAndAndroid(): Unit