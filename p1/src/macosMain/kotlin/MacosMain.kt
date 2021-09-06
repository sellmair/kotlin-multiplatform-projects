@file:Suppress("unused")

import kotlinx.cinterop.pointed
import platform.posix.stat
import withPosix.getMyStructPointer
import withPosix.getStructFromPosix
import withPosix.getStructPointerFromPosix

actual fun getDefaultMask(): common_size_t = 20u

actual fun setMask(mask: common_size_t) = Unit