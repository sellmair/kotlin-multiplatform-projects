@file:Suppress("unused", "unused_variable")

import com.russhwolf.settings.Settings
import okio.Path.Companion.toPath

val someSettings: Settings get() = TODO()

expect fun myExpectation(settings: Settings): Settings

fun x() {
    "".toPath()
}
