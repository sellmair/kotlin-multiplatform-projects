@file:Suppress("RemoveExplicitTypeArguments")

package pkg

import kotlinx.cinterop.convert
import kotlinx.cinterop.narrow
import platform.posix.size_t
import platform.posix.ssize_t

fun print() {
    println(ssize_t.MAX_VALUE)

    coercions(0.convert<ssize_t>(), 0u.convert<size_t>())
    coercions(17.convert<ssize_t>(), 17u.convert<size_t>())
    coercions(50.convert<ssize_t>(), 50u.convert<size_t>())

    bits(255u.convert<ssize_t>(), 255.convert<size_t>())
    bits(ssize_t.MAX_VALUE, size_t.MAX_VALUE)

    divMod(41.convert<ssize_t>(), 41u.convert<size_t>())
    divMod((-41).convert<ssize_t>(), 0.convert<size_t>())

    println(33000.convert<ssize_t>().let { "Narrowed $it to Short: ${it.narrow<Short>()}" })

    duration(6.convert<ssize_t>(), 25.convert<ssize_t>())
    rangeUntil(3, 5)

    comparisons()

    rotations(66666.convert<ssize_t>(), 66666u.convert<size_t>())
    rotations((-66666).convert<ssize_t>(), 0u.convert<size_t>())

    toStringWithRadix((-31).convert<ssize_t>(), 31u.convert<size_t>())

    progressionsAndRanges()

    platformIntMemberApi(
        (-42).convert<ssize_t>(), 42u.convert<size_t>(), 1, 2, 3, 4, 5u, 6u, 7u, 8u, 9.1f, 10.2
    )

    pointers()

    val (a1, a2) = arrays()
    println("\nArrays")
    intArray(a1, a2)

    val (a3, a4) = unsignedArrays()
    println("\n Unsigned arrays")
    uIntArray(a3, a4)
}
