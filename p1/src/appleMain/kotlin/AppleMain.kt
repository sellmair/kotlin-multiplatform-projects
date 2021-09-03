@file:Suppress("unused", "NO_ACTUAL_FOR_EXPECT")

import kotlinx.cinterop.CValuesRef
import kotlinx.cinterop.UnsafeNumber
import platform.posix.FILE
import platform.posix.size_t

internal typealias common_size_t = size_t

@OptIn(UnsafeNumber::class)
expect fun fread(
    __ptr: CValuesRef<*>?,
    __size: size_t,
    __nitems: size_t,
    __stream: CValuesRef<FILE>?
): size_t

expect fun plus(first: size_t, second: size_t)

//@OptIn(UnsafeNumber::class)
//fun setMask(value: size_t, mask: size_t): size_t {
//    return value.and(mask)
//}

expect fun getDefaultMask(): size_t

expect fun setMask(mask: common_size_t)

//fun initialization() {
//    setMask(getDefaultMask())
//}