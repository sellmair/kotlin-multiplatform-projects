@file:Suppress("unused")

import kotlinx.cinterop.UnsafeNumber
import kotlinx.cinterop.convert
import platform.posix.size_t

typealias X = Any

fun xPlatform1(): X = TODO()
fun xPlatfrom2(): X? = TODO()
fun xCommon(): X? = TODO()
fun fromCommonCode() {
    invariantUseOfX(mutableListOf(xPlatform1(), xPlatfrom2()))
    val comingFrom1 = mutableListOf(xPlatform1())
    val comingFrom2 = mutableListOf(xPlatfrom2())
    val common = mutableListOf(xCommon())
    invariantUseOfX(comingFrom1)
    invariantUseOfX(comingFrom2)
    invariantUseOfX(common)
}

fun invariantUseOfX(list: MutableList<X?>) {

}

fun x(value: size_t) {
    // WORK
}

@OptIn(UnsafeNumber::class)
fun y() {
    setMask(getDefaultMask().convert())
}