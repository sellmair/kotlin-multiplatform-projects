@file:Suppress("unused")

import kotlinx.cinterop.CValuesRef
import kotlinx.cinterop.convert
import platform.posix.FILE
import platform.posix.fread
import platform.posix.size_t

actual fun fread(
    __ptr: CValuesRef<*>?,
    __size: common_size_t,
    __nitems: common_size_t,
    __stream: CValuesRef<FILE>?
): common_size_t = fread(__ptr, __size.convert(), __nitems.convert(), __stream).convert()

actual fun plus(first: common_size_t, second: common_size_t) {

}

actual fun getDefaultMask(): common_size_t {
    // call some platform API which ULong and then what? Coerce it to Int?
    TODO()
}

actual fun setMask(mask: common_size_t) {
    TODO()
}
