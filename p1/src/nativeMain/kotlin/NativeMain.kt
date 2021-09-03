@file:Suppress("unused")

import kotlinx.cinterop.UnsafeNumber
import kotlinx.cinterop.pointed
import platform.posix.fopen
import platform.posix.stat
import withPosix.getMyStructPointer
import withPosix.getStructFromPosix
import withPosix.getStructPointerFromPosix

object NativeMain {
    val structFromPosix = getStructFromPosix()
    val structPointerFromPosix = getStructPointerFromPosix()

    object MyStruct {
        val struct = getMyStructPointer()?.pointed ?: error("Missing my struct")
        val posixProperty: stat = struct.posixProperty
        val doubleProperty: Double = struct.doubleProperty
    }

}


@UnsafeNumber(["a: kotlin/Int", "b: kotlin/Long"])
typealias X = Int


fun someFunctionInNativeMain(x: X) {

}