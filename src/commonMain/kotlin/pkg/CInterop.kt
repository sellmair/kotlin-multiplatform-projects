@file:Suppress("DuplicatedCode")

package pkg

import kotlinx.cinterop.*
import platform.posix.size_t
import platform.posix.size_tVar
import platform.posix.ssize_t
import platform.posix.ssize_tVar

fun pointers() = memScoped {
    val sa = allocArray<ssize_tVar>(3)

    sa[0] = (-1).convert()
    sa[1] = (-2).convert()
    sa[2] = (-3).convert()

    println("Signed array: [${sa.pointed.value}, ${(sa + 1)?.pointed?.value}, ${sa.get<ssize_t>(2)}]")

    val usa = allocArray<size_tVar>(3)

    usa[0] = 1u.convert()
    usa[1] = 2u.convert()
    usa[2] = 3u.convert()

    println("Unsigned array: [${usa.pointed.value}, ${(usa + 1)?.pointed?.value}, ${usa.get<size_t>(2)}]")
}
