package pkg

import kotlinx.cinterop.CValuesRef
import platform.posix.FILE
import platform.posix.size_t

/*
* Platform array types are used in signatures since posix doesn't have APIs
* with platform dependent integers. The general intention is to disallow
* explicit use of such platform types.
*/
expect fun arrays(): Pair<PlatformIntArray, PlatformIntArray>
expect fun unsignedArrays(): Pair<PlatformUIntArray, PlatformUIntArray>

expect fun fread(
    __ptr: CValuesRef<*>?,
    __size: size_t,
    __nitems: size_t,
    __stream: CValuesRef<FILE>?
): size_t
