@file:Suppress("RemoveRedundantCallsOfConversionMethods", "RemoveExplicitTypeArguments")

package pkg

import kotlinx.cinterop.convert
import platform.posix.size_t
import platform.posix.ssize_t
import kotlin.time.*

@OptIn(ExperimentalTime::class)
fun duration(dayCount: ssize_t, hourCount: ssize_t) {
    println(
        "$dayCount days and $hourCount hours is ${
            if (dayCount.days + hourCount.hours > 7.days) "more" else "not more"
        } than a week"
    )
    24.convert<ssize_t>().let { hours ->
        println("$hours hours equal to a day: ${hours.toDuration(DurationUnit.HOURS) == Duration.days(1)}")
    }
}

fun coercions(signed: ssize_t, unsigned: size_t) {
    val atLeastS = signed.coerceAtLeast(15.convert<ssize_t>())
    val atMostS = signed.coerceAtMost(42.convert<ssize_t>())
    val inRangeS = signed.coerceIn(15.convert<ssize_t>()..42.convert<ssize_t>())

    val atLeastU = unsigned.coerceAtLeast(15u.convert<size_t>())
    val atMostU = unsigned.coerceAtMost(42u.convert<size_t>())
    val inRangeU = unsigned.coerceIn(15u.convert<size_t>()..42u.convert<size_t>())

    println("Coercions: $signed to $atLeastS, $atMostS, $inRangeS; $unsigned to $atLeastU, $atMostU, $inRangeU")
}

fun bits(signed: ssize_t, unsigned: size_t) {
    val sl = signed.countLeadingZeroBits()
    val st = signed.countTrailingZeroBits()
    val so = signed.countOneBits()

    val ul = unsigned.countLeadingZeroBits()
    val ut = unsigned.countTrailingZeroBits()
    val uo = unsigned.countOneBits()

    println(
        "One bits; leading zeros; trailing zeros. " +
                "For signed $signed: $so, $sl, $st; for unsigned $unsigned: $uo, $ul, $ut"
    )
    println("Signed $signed: highest: ${signed.takeHighestOneBit()}; lowest: ${signed.takeLowestOneBit()}")
    println("Unsigned $unsigned: highest: ${unsigned.takeHighestOneBit()}; lowest: ${unsigned.takeLowestOneBit()}")
}

fun divMod(signed: ssize_t, unsigned: size_t) {
    val divStuff = sequence {
        yield(signed.div(2.toByte()))
        yield(signed.div(2.toShort()))
        yield(signed.div(2.toInt()))
        yield(signed.div(2.toLong()))

        yield(signed.mod(2.toByte()))
        yield(signed.mod(2.toShort()))
        yield(signed.mod(2.toInt()))
        yield(signed.mod(2.toLong()))

        yield(signed.floorDiv(2.toByte()))
        yield(signed.floorDiv(2.toShort()))
        yield(signed.floorDiv(2.toInt()))
        yield(signed.floorDiv(2.toLong()))

        yield(signed.rem(2.toByte()))
        yield(signed.rem(2.toShort()))
        yield(signed.rem(2.toInt()))
        yield(signed.rem(2.toLong()))

        yield(unsigned.div(2u.toUByte()))
        yield(unsigned.div(2u.toUShort()))
        yield(unsigned.div(2u.toUInt()))
        yield(unsigned.div(2u.toULong()))

        yield(unsigned.mod(2u.toUByte()))
        yield(unsigned.mod(2u.toUShort()))
        yield(unsigned.mod(2u.toUInt()))
        yield(unsigned.mod(2u.toULong()))

        yield(unsigned.floorDiv(2u.toUByte()))
        yield(unsigned.floorDiv(2u.toUShort()))
        yield(unsigned.floorDiv(2u.toUInt()))
        yield(unsigned.floorDiv(2u.toULong()))

        yield(unsigned.rem(2u.toUByte()))
        yield(unsigned.rem(2u.toUShort()))
        yield(unsigned.rem(2u.toUInt()))
        yield(unsigned.rem(2u.toULong()))
    }

    val iterator = divStuff.iterator()

    println("### Div-mod by 2 stuff for $signed, $unsigned ###")
    for (type in listOf("Signed", "Unsigned")) {
        for (op in listOf("div", "mod", "floorDiv", "rem")) {
            listOf("8", "16", "32", "64").joinToString { bitness ->
                "$type#$op($bitness): ${iterator.next()}"
            }.let(::println)
        }
    }

    check(!iterator.hasNext())
}

fun rangeUntil(from: Int, to: Int) {
    val signedFrom = from.convert<ssize_t>()
    val signedTo = to.convert<ssize_t>()
    val unsignedFrom = from.convert<size_t>()
    val unsignedTo = to.convert<size_t>()

    println("Signed range: $signedFrom until $signedTo: ${(signedFrom until signedTo).toList().joinToString()}")
    println(
        "Unsigned range: $unsignedFrom until $unsignedTo: ${(unsignedFrom until unsignedTo).toList().joinToString()}"
    )
}

fun comparisons() {
    val oneS = 1.convert<ssize_t>()
    val twoS = 2.convert<ssize_t>()
    val mOneS = (-1).convert<ssize_t>()
    val mTwoS = (-2).convert<ssize_t>()
    val oneU = 1u.convert<size_t>()
    val twoU = 2u.convert<size_t>()
    println("1 and 2: ${oneS.compareTo(twoS)}; 1 and 1: ${oneS.compareTo(oneS)}: 2 and 1: ${twoS.compareTo(oneS)}")
    println(
        "-1 and -2: ${mOneS.compareTo(mTwoS)}; -1 and -1: ${mOneS.compareTo(mOneS)}: -2 and -1: ${
            mTwoS.compareTo(
                mOneS
            )
        }"
    )
    println("1u and 2u: ${oneU.compareTo(twoU)}; 1u and 1u: ${oneU.compareTo(oneU)}: 2u and 1u: ${twoU.compareTo(oneU)}")

    println("1 < 1: ${oneS < twoS} 1 < -2: ${oneS < mTwoS} -2 < 2: ${mTwoS < twoS}")
    println("1u < 2u: ${oneU < twoU} 1u = 2u: ${oneU == twoU} 1u > 2u ${oneU > twoU}")

    println("With plain ints 1 < 2: ${oneS < 2.toByte()} ${oneS < 2.toShort()} ${oneS < 2.toInt()} ${oneS < 2.toLong()}")
    println("With plain ints 1u < 2u: ${oneU < 2.toUByte()} ${oneU < 2.toUShort()} ${oneU < 2.toUInt()} ${oneU < 2.toULong()}")
}

@OptIn(ExperimentalStdlibApi::class)
fun rotations(signed: ssize_t, unsigned: size_t) {
    println("Rotations. Signed $signed: <-- ${signed.rotateLeft(1)} | --> ${signed.rotateRight(1)}")
    println("Rotations. Unsigned $unsigned: <-- ${unsigned.rotateLeft(1)} | --> ${unsigned.rotateRight(1)}")
}

fun toStringWithRadix(signed: ssize_t, unsigned: size_t) {
    println("Radix. Signed $signed: ${listOf(2, 8, 16).joinToString("; ") { radix -> signed.toString(radix) }}")
    println("Radix. Unsigned $unsigned: ${listOf(2, 8, 16).joinToString("; ") { radix -> unsigned.toString(radix) }}")
}

fun progressionsAndRanges() {
    PlatformIntProgression.fromClosedRange((-3).convert<ssize_t>(), (-7).convert<ssize_t>(), (-2).convert<ssize_t>())
        .let { myProgression ->
            val sum = myProgression.fold(0.convert<ssize_t>()) { acc, next -> acc + next }
            println(
                "Signed progression. first: ${myProgression.first}; " +
                        "last: ${myProgression.last}; " +
                        "step: ${myProgression.step};" +
                        "sum: $sum "
            )
        }

    PlatformUIntProgression.fromClosedRange((3).convert<size_t>(), (7).convert<size_t>(), (2).convert<ssize_t>())
        .let { myProgression ->
            val sum = myProgression.fold(0.convert<size_t>()) { acc, next -> acc + next }
            println(
                "Unsigned progression. first: ${myProgression.first}; " +
                        "last: ${myProgression.last}; " +
                        "step: ${myProgression.step}; " +
                        "sum: $sum "
            )
        }

    println("Empty ranges. Signed: ${PlatformIntRange.EMPTY}; Unsigned: ${PlatformUIntRange.EMPTY}")
}
