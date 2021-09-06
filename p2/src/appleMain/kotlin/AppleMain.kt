@file:Suppress("unused")

import kotlinx.cinterop.UnsafeNumber
import kotlinx.cinterop.convert
import platform.posix.size_t

fun x(value: size_t) {

}

@OptIn(UnsafeNumber::class)
fun y() {
    x(getDefaultMask().convert())
}