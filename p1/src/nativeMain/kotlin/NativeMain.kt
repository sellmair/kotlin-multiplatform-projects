@file:Suppress("unused")

import nativeHelper.nativeHelper
import unixHelper.unixHelper

object NativeMain {
    val native = nativeHelper()
    val unix = unixHelper()
}
