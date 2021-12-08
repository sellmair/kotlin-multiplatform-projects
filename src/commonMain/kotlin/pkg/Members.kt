@file:Suppress("DuplicatedCode")

package pkg

import platform.posix.size_t
import platform.posix.ssize_t

fun platformIntMemberApi(
    signed: ssize_t,
    unsigned: size_t,
    b: Byte,
    s: Short,
    i: Int,
    l: Long,
    ub: UByte,
    us: UShort,
    ui: UInt,
    ul: ULong,
    f: Float,
    d: Double,
) {
    println("$signed < $b: ${signed < b}")
    println("$signed < $s: ${signed < s}")
    println("$signed < $i: ${signed < i}")
    println("$signed < $l: ${signed < l}")

    println("$signed.compareTo($b): ${signed.compareTo(b)}")
    println("$signed.compareTo($s): ${signed.compareTo(s)}")
    println("$signed.compareTo($i): ${signed.compareTo(i)}")
    println("$signed.compareTo($l): ${signed.compareTo(l)}")

    println("$signed / $b: ${signed / b}")
    println("$signed / $s: ${signed / s}")
    println("$signed / $i: ${signed / i}")
    println("$signed / $l: ${signed / l}")
    println("$signed / $f: ${signed / f}")
    println("$signed / $d: ${signed / d}")

    println("$signed == $signed: ${signed == signed}")

    println("$signed - $b: ${signed - b}")
    println("$signed - $s: ${signed - s}")
    println("$signed - $i: ${signed - i}")
    println("$signed - $l: ${signed - l}")
    println("$signed - $d: ${signed - d}")
    println("$signed - $f: ${signed - f}")

    println("$signed + $b: ${signed + b}")
    println("$signed + $s: ${signed + s}")
    println("$signed + $i: ${signed + i}")
    println("$signed + $l: ${signed + l}")
    println("$signed + $f: ${signed + f}")
    println("$signed + $d: ${signed + d}")

    println("$signed % $b: ${signed % b}")
    println("$signed % $s: ${signed % s}")
    println("$signed % $i: ${signed % i}")
    println("$signed % $l: ${signed % l}")
    println("$signed % $f: ${signed % f}")
    println("$signed % $d: ${signed % d}")

    println("$signed * $b: ${signed * b}")
    println("$signed * $s: ${signed * s}")
    println("$signed * $i: ${signed * i}")
    println("$signed * $l: ${signed * l}")
    println("$signed * $f: ${signed * f}")
    println("$signed * $d: ${signed * d}")

    println("+$signed: ${+signed}")
    println("-$signed: ${-signed}")

    println("$signed.and($signed): ${signed.and(signed)}")
    println("$signed.or($signed): ${signed.or(signed)}")
    println("$signed.xor($signed): ${signed.xor(signed)}")
    println("$signed.inv(): ${signed.inv()}")
    println("$signed.shl(1): ${signed.shl(1)}")
    println("$signed.shr(2): ${signed.shr(2)}")
    println("$signed.ushr(3): ${signed.ushr(3)}")

    println("$unsigned < $ub: ${unsigned < ub}")
    println("$unsigned < $us: ${unsigned < us}")
    println("$unsigned < $ui: ${unsigned < ui}")
    println("$unsigned < $ul: ${unsigned < ul}")

    unsigned.compareTo(ub)
    unsigned.compareTo(us)
    unsigned.compareTo(ui)
    unsigned.compareTo(ul)

    println("$unsigned / $ub: ${unsigned / ub}")
    println("$unsigned / $us: ${unsigned / us}")
    println("$unsigned / $ui: ${unsigned / ui}")
    println("$unsigned / $ul: ${unsigned / ul}")

    println("$unsigned == $unsigned: ${unsigned == unsigned}")

    println("$unsigned - $ub: ${unsigned - ub}")
    println("$unsigned - $us: ${unsigned - us}")
    println("$unsigned - $ui: ${unsigned - ui}")
    println("$unsigned - $ul: ${unsigned - ul}")

    println("$unsigned + $ub: ${unsigned + ub}")
    println("$unsigned + $us: ${unsigned + us}")
    println("$unsigned + $ui: ${unsigned + ui}")
    println("$unsigned + $ul: ${unsigned + ul}")

    println("$unsigned % $ub: ${unsigned % ub}")
    println("$unsigned % $us: ${unsigned % us}")
    println("$unsigned % $ui: ${unsigned % ui}")
    println("$unsigned % $ul: ${unsigned % ul}")

    println("$unsigned * $ub: ${unsigned * ub}")
    println("$unsigned * $us: ${unsigned * us}")
    println("$unsigned * $ui: ${unsigned * ui}")
    println("$unsigned * $ul: ${unsigned * ul}")

    println("$unsigned.and($unsigned): ${unsigned.and(unsigned)}")
    println("$unsigned.or($unsigned): ${unsigned.or(unsigned)}")
    println("$unsigned.xor($unsigned): ${unsigned.xor(unsigned)}")
    println("$unsigned.inv(): ${unsigned.inv()}")
    println("$unsigned.shl(1): ${unsigned.shl(1)}")
    println("$unsigned.shr(2): ${unsigned.shr(2)}")
}
