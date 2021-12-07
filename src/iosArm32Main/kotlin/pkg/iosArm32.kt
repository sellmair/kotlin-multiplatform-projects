package pkg

import kotlinx.cinterop.CValuesRef
import platform.posix.FILE
import platform.posix.size_t

actual fun fread(
    __ptr: CValuesRef<*>?,
    __size: size_t,
    __nitems: size_t,
    __stream: CValuesRef<FILE>?
): size_t = platform.posix.fread(__ptr, __size, __nitems, __stream)

actual fun arrays(): Pair<PlatformIntArray, PlatformIntArray> {
    return intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 42, 42, 42, 42, 42) to
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 42, 42, 42, 42, 42, 100, 0, 0, 0, 0, 0)
}

@OptIn(ExperimentalUnsignedTypes::class)
actual fun unsignedArrays() =
    uintArrayOf(1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u, 42u, 42u, 42u, 42u, 42u) to
            uintArrayOf(1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u, 42u, 42u, 42u, 42u, 42u, 100u, 0u, 0u, 0u, 0u, 0u)
