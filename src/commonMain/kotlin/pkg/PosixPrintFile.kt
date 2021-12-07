@file:Suppress("RemoveExplicitTypeArguments")

package pkg

import kotlinx.cinterop.*
import platform.posix.FILE
import platform.posix.fread
import platform.posix.size_t
import platform.posix.size_tVar

fun printFile(file: CPointer<FILE>) = memScoped {
    val singleCharBuffer = alloc<size_tVar>()
    while (true) {
        val bytesRead = fread(
            singleCharBuffer.ptr,
            Byte.SIZE_BYTES.convert<size_t>(),
            1.convert<size_t>(),
            file
        )
        if (bytesRead > 0u) {
            print(singleCharBuffer.value.toInt().toChar())
        } else {
            break
        }
    }
}
