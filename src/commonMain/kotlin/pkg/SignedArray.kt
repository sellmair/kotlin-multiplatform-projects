@file:Suppress("RemoveExplicitTypeArguments", "ReplaceAssociateFunction", "DuplicatedCode")

package pkg

import kotlinx.cinterop.convert
import platform.posix.ssize_t
import kotlin.random.Random

fun intArray(intArray: PlatformIntArray, supportArray: PlatformIntArray) {
    println("intArray.contentToString(): ${intArray.contentToString()}")
    println("supportArray.contentToString(): ${supportArray.contentToString()}")
    println("all { 3 < it && it < 7 }: ${intArray.all { 3 < it && it < 7 }}")
    println("any(): ${intArray.any()}")
    println("any { 3 < it && it < 7 }: ${intArray.any { 3 < it && it < 7 }}")
    println("asIterable().iterator().hasNext(): ${intArray.asIterable().iterator().hasNext()}")
    println("asList().subList(0, 1): ${intArray.asList().subList(0, 1)}")
    println("asSequence().toList(): ${intArray.asSequence().toList()}")
    println("associate { it to it }: ${intArray.associate { it to it }}")
    println("associateBy { it.toDouble() }: ${intArray.associateBy { it.toDouble() }}")
    println(
        "associateBy({ it.toDouble() }, { it.toShort() }): ${
            intArray.associateBy(
                { it.toDouble() },
                { it.toShort() })
        }"
    )
    println("associateByTo(mutableMapOf()) { it.toDouble() }: ${intArray.associateByTo(mutableMapOf()) { it.toDouble() }}")
    println(
        "associateByTo(mutableMapOf(), { it.toDouble() }, { it.toShort() }): ${
            intArray.associateByTo(
                mutableMapOf(),
                { it.toDouble() },
                { it.toShort() })
        }"
    )
    println("associateTo(mutableMapOf()) { it.toString() to it.toDouble() }: ${intArray.associateTo(mutableMapOf()) { it.toString() to it.toDouble() }}")
    println("associateWith { it.shl(5) }: ${intArray.associateWith { it.shl(5) }}")
    println("associateWithTo(mutableMapOf()) { it.shr(1) }: ${intArray.associateWithTo(mutableMapOf()) { it.shr(1) }}")
    println("component1(): ${intArray.component1()}")
    println("component2(): ${intArray.component2()}")
    println("component3(): ${intArray.component3()}")
    println("component4(): ${intArray.component4()}")
    println("component5(): ${intArray.component5()}")
    val (e1, e2, e3, e4, e5) = intArray
    println("val (e1, e2, e3, e4, e5) = intArray: $e1, $e2, $e3, $e4, $e5")
    println("contains(42.convert<ssize_t>()): ${intArray.contains(42.convert<ssize_t>())}")
    println("contentEquals(supportArray): ${intArray.contentEquals(supportArray)}")
    println("contentHashCode(): ${intArray.contentHashCode()}")
    println("copyInto(supportArray, 1, 1, 3): ${intArray.copyInto(supportArray, 1, 1, 3).contentToString()}")
    println("copyOf(): ${intArray.copyOf().contentToString()}")
    println("copyOf(10): ${intArray.copyOf(10).contentToString()}")
    println("copyOfRange(1, 3): ${intArray.copyOfRange(1, 3).contentToString()}")
    println("count(): ${intArray.count()}")
    println("count { it > 5 }: ${intArray.count { it > 5 }}")
    println("distinct(): ${intArray.distinct()}")
    println("distinctBy { it % 2 }: ${intArray.distinctBy { it % 2 }}")
    println("drop(2): ${intArray.drop(2)}")
    println("dropLast(3): ${intArray.dropLast(3)}")
    println("dropLastWhile { it > 5 }: ${intArray.dropLastWhile { it > 5 }}")
    println("dropWhile { it < 3 }: ${intArray.dropWhile { it < 3 }}")
    println("elementAt(0): ${intArray.elementAt(0)}")
    println("elementAtOrElse(Int.MAX_VALUE) { 42.convert<ssize_t>() }: ${intArray.elementAtOrElse(Int.MAX_VALUE) { 42.convert<ssize_t>() }}")
    println("elementAtOrNull(0): ${intArray.elementAtOrNull(0)}")
    println("fill(42.convert<ssize_t>(), 0, 2): ${intArray.fill(42.convert<ssize_t>(), 0, 2)}")
    println("filter { it == 42.convert<ssize_t>() }: ${intArray.filter { it == 42.convert<ssize_t>() }}")
    println("filterIndexed { ix, it -> it > ix }: ${intArray.filterIndexed { ix, it -> it > ix.toInt() }}")
    println("filterIndexedTo(mutableSetOf()) { ix, it -> it > ix }: ${intArray.filterIndexedTo(mutableSetOf()) { ix, it -> it > ix.toInt() }}")
    println("filterNot { it.toString().length > 1 }: ${intArray.filterNot { it.toString().length > 1 }}")
    println("filterNotTo(mutableListOf()) { false }: ${intArray.filterNotTo(mutableListOf()) { false }}")
    println("filterTo(mutableListOf()) { true }: ${intArray.filterTo(mutableListOf()) { true }}")
    println("find { it == 42.convert<ssize_t>() }: ${intArray.find { it == 42.convert<ssize_t>() }}")
    println("findLast { it % 2 == 0.convert<ssize_t>() }: ${intArray.findLast { it % 2 == 0.convert<ssize_t>() }}")
    println("first(): ${intArray.first()}")
    println("first { it + 4L == 15L }: ${intArray.first { it + 4L == 46L }}")
    println("firstOrNull(): ${intArray.firstOrNull()}")
    @Suppress("INCOMPATIBLE_TYPES")
    println("firstOrNull { it is Long }: ${intArray.firstOrNull { it is Long }}")
    println("flatMap { listOf(it, it + 1) }: ${intArray.flatMap { listOf(it, it + 1) }}")
    println("flatMapIndexed { ix, it -> listOf(ix, it) }: ${intArray.flatMapIndexed { ix, it -> listOf(ix, it) }}")
    println(
        "flatMapIndexedTo(mutableListOf()) { ix, it -> listOf(ix, ix + it) }: ${
            intArray.flatMapIndexedTo(
                mutableListOf()
            ) { ix, it -> listOf(ix, ix + it.toInt()) }
        }"
    )
    println(
        "flatMapTo(mutableListOf()) { setOf(it, 1 - it) }: ${
            intArray.flatMapTo(mutableListOf()) {
                setOf(
                    it,
                    1 - it
                )
            }
        }"
    )
    println("fold(5) { acc, next -> (acc + next).toInt() }: ${intArray.fold(5) { acc, next -> (acc + next).toInt() }}")
    println("foldIndexed(5.convert<ssize_t>()) { _, acc, next -> acc + next }: ${intArray.foldIndexed(5.convert<ssize_t>()) { _, acc, next -> acc + next }}")
    println("foldRight(5) { acc, next -> (acc + next).toInt() }: ${intArray.foldRight(5) { acc, next -> (acc + next).toInt() }}")
    println("foldRightIndexed(5.convert<ssize_t>()) { _, acc, next -> acc + next }: ${intArray.foldRightIndexed(5.convert<ssize_t>()) { _, acc, next -> acc + next }}")
    println("^^ntArray.forEach(::print)")
    intArray.forEach(::print).also { println() }
    println("^^intArray.forEachIndexed { ix, it -> print(\"\$ix: \$it\") }: ")
    intArray.forEachIndexed { ix, it -> print("$ix: $it") }.also { println() }
    println("getOrElse(42) { 42.convert<ssize_t>() }: ${intArray.getOrElse(42) { 42.convert<ssize_t>() }}")
    println("getOrNull(42): ${intArray.getOrNull(42)}")
    println("groupBy { it % 2 == 1.convert<ssize_t>() }: ${intArray.groupBy { it % 2 == 1.convert<ssize_t>() }}")
    println(
        "groupBy({ it % 2 == 1.convert<ssize_t>() }, ssize_t::toString): ${
            intArray.groupBy(
                { it % 2 == 1.convert<ssize_t>() },
                ssize_t::toString
            )
        }"
    )
    println("groupByTo(mutableMapOf()) { it % 2 == 1.convert<ssize_t>() }: ${intArray.groupByTo(mutableMapOf()) { it % 2 == 1.convert<ssize_t>() }}")
    println(
        "groupByTo(mutableMapOf(), { it % 2 == 1.convert<ssize_t>() }, ssize_t::toString): ${
            intArray.groupByTo(
                mutableMapOf(),
                { it % 2 == 1.convert<ssize_t>() },
                ssize_t::toString
            )
        }"
    )
    println("indexOf(4.convert<ssize_t>()): ${intArray.indexOf(4.convert<ssize_t>())}")
    println("indexOfFirst { it == 5.convert<ssize_t>() }: ${intArray.indexOfFirst { it == 5.convert<ssize_t>() }}")
    println("indexOfLast { it == 5.convert<ssize_t>() }: ${intArray.indexOfLast { it == 5.convert<ssize_t>() }}")
    println("indices: ${intArray.indices}")
    println("intersect(supportArray.asIterable()): ${intArray.intersect(supportArray.asIterable())}")
    println("isEmpty(): ${intArray.isEmpty()}")
    println("isNotEmpty(): ${intArray.isNotEmpty()}")
    println("joinTo(StringBuilder(\"joinTo: \")): ${intArray.joinTo(StringBuilder("joinTo: "))}")
    println("joinToString(): ${intArray.joinToString()}")
    println("last(): ${intArray.last()}")
    println("last { it > 5 }: ${intArray.last { it > 5 }}")
    println("lastIndex: ${intArray.lastIndex}")
    println("lastIndexOf(42.convert<ssize_t>()): ${intArray.lastIndexOf(42.convert<ssize_t>())}")
    println("lastOrNull(): ${intArray.lastOrNull()}")
    println("lastOrNull { it.toString().length < 2 }: ${intArray.lastOrNull { it.toString().length < 2 }}")
    println("map(ssize_t::toULong): ${intArray.map(ssize_t::toULong)}")
    println("mapIndexed { ix, it -> it.toUByte() }: ${intArray.mapIndexed { _, it -> it.toUByte() }}")
    println("mapIndexedTo(mutableListOf()) { ix, it -> it.toUShort() }: ${intArray.mapIndexedTo(mutableListOf()) { _, it -> it.toUShort() }}")
    println("mapTo(mutableListOf()) { it + 2 }: ${intArray.mapTo(mutableListOf()) { it + 2 }}")
    println("maxByOrNull { it }: ${intArray.maxByOrNull { it }}")
    println("maxOf { it.toDouble() }: ${intArray.maxOf { it.toDouble() }}")
    println("maxOf { it.toFloat() }: ${intArray.maxOf { it.toFloat() }}")
    println("maxOf { it + 1 }: ${intArray.maxOf { it + 1 }}")
    println("maxOfOrNull { it.toDouble() }: ${intArray.maxOfOrNull { it.toDouble() }}")
    println("maxOfOrNull { it.toFloat() }: ${intArray.maxOfOrNull { it.toFloat() }}")
    println("maxOfOrNull { it + 1 }: ${intArray.maxOfOrNull { it + 1 }}")
    println(
        "maxOfWith({ s1, s2 -> s1.compareTo(s2) }) { it.toString() }: ${
            intArray.maxOfWith({ s1, s2 ->
                s1.compareTo(
                    s2
                )
            }) { it.toString() }
        }"
    )
    println(
        "maxOfWithOrNull({ s1, s2 -> s1.compareTo(s2) }) { it.toString() }: ${
            intArray.maxOfWithOrNull({ s1, s2 ->
                s1.compareTo(
                    s2
                )
            }) { it.toString() }
        }"
    )
    println("maxOrNull(): ${intArray.maxOrNull()}")
    println("maxWithOrNull { s1, s2 -> s1.compareTo(s2) }: ${intArray.maxWithOrNull { s1, s2 -> s1.compareTo(s2) }}")
    println("minByOrNull { it.toString() }: ${intArray.minByOrNull { it.toString() }}")
    println("minOf { it.toDouble() }: ${intArray.minOf { it.toDouble() }}")
    println("minOf { it.toFloat() }: ${intArray.minOf { it.toFloat() }}")
    println("minOf { it + 1 }: ${intArray.minOf { it + 1 }}")
    println("minOfOrNull { it.toDouble() }: ${intArray.minOfOrNull { it.toDouble() }}")
    println("minOfOrNull { it.toFloat() }: ${intArray.minOfOrNull { it.toFloat() }}")
    println("minOfOrNull { it + 1 }: ${intArray.minOfOrNull { it + 1 }}")
    println(
        "minOfWith({ s1, s2 -> s1.compareTo(s2) }) { it.toString() }: ${
            intArray.minOfWith({ s1, s2 ->
                s1.compareTo(
                    s2
                )
            }) { it.toString() }
        }"
    )
    println(
        "minOfWithOrNull({ s1, s2 -> s1.compareTo(s2) }) { it.toString() }: ${
            intArray.minOfWithOrNull({ s1, s2 ->
                s1.compareTo(
                    s2
                )
            }) { it.toString() }
        }"
    )
    println("minOrNull(): ${intArray.minOrNull()}")
    println(
        "minWithOrNull { s1, s2 -> s1.toString().compareTo(s2.toString()) }: ${
            intArray.minWithOrNull { s1, s2 ->
                s1.toString().compareTo(s2.toString())
            }
        }"
    )
    println("none(): ${intArray.none()}")
    println("none { it > 0 }: ${intArray.none { it > 0 }}")
    println(": intArray.onEach { print(\"\$it \") }: ${intArray.onEach { print("$it ") }.contentToString()} ")
    println(
        ": intArray.onEachIndexed { ix, it -> print(\"\$ix: \$it \") }: ${
            intArray.onEachIndexed { ix, it -> print("$ix: $it ") }.contentToString()
        }"
    )
    println("partition { it < 6 }: ${intArray.partition { it < 6 }}")
    println("intArray + 1.convert<ssize_t>(): ${(intArray + 1.convert<ssize_t>()).contentToString()}")
    println("intArray + listOf(42.convert<ssize_t>()): ${(intArray + listOf(42.convert<ssize_t>())).contentToString()}")
    println("intArray + supportArray: ${(intArray + supportArray).contentToString()}")
    println("random(): ${intArray.random()}")
    println("random(Random(42)): ${intArray.random(Random(42))}")
    println("randomOrNull(): ${intArray.randomOrNull()}")
    println("randomOrNull(Random(42)): ${intArray.randomOrNull(Random(42))}")
    println("reduce { acc, next -> acc + next }: ${intArray.reduce { acc, next -> acc + next }}")
    println("reduceIndexed { ix, acc, next -> ix.toInt() + acc + next }: ${intArray.contentToString()} -> ${intArray.reduceIndexed { ix, acc, next -> ix.toInt() + acc + next }}")
    println("reduceIndexedOrNull { ix, acc, next -> ix.toInt() + acc + next }: ${intArray.reduceIndexedOrNull { ix, acc, next -> ix.toInt() + acc + next }}")
    println("reduceOrNull { acc, next -> acc + next }: ${intArray.reduceOrNull { acc, next -> acc + next }}")
    println("reduceRight { acc, next -> acc + next }: ${intArray.reduceRight { acc, next -> acc + next }}")
    println("reduceRightIndexed { ix, acc, next -> ix.toInt() + acc + next }: ${intArray.contentToString()} -> ${intArray.reduceRightIndexed { ix, acc, next -> ix.toInt() + acc + next }}")
    println("reduceRightIndexedOrNull { ix, acc, next -> ix.toInt() + acc + next }: ${intArray.reduceRightIndexedOrNull { ix, acc, next -> ix.toInt() + acc + next }}")
    println("reduceRightOrNull { acc, next -> acc + next }: ${intArray.reduceRightOrNull { acc, next -> acc + next }}")
    println("reverse(): ${intArray.reverse()}")
    println("reverse(1, 3): ${intArray.reverse(1, 3)}")
    println("reversed(): ${intArray.reversed()}")
    println("reversedArray(): ${intArray.reversedArray()}")
    println("runningFold(5) { acc, next -> (acc + next).toInt() }: ${intArray.runningFold(5) { acc, next -> (acc + next).toInt() }}")
    println("runningFoldIndexed(5) { ix, acc, next -> (acc + next + ix).toInt() }: ${intArray.runningFoldIndexed(5) { ix, acc, next -> (acc + next + ix.toInt()).toInt() }}")
    println("runningReduce { acc, next -> acc + next }: ${intArray.runningReduce { acc, next -> acc + next }}")
    println("runningReduceIndexed { ix, acc, next -> ix.toInt() + acc + next }: ${intArray.runningReduceIndexed { ix, acc, next -> ix.toInt() + acc + next }}")
    println("scan(1.convert<ssize_t>()) { acc, next -> acc + next }: ${intArray.scan(1.convert<ssize_t>()) { acc, next -> acc + next }}")
    println("scanIndexed(1.convert<ssize_t>()) { ix, acc, next -> ix.toInt() + acc + next }: ${intArray.scanIndexed(1.convert<ssize_t>()) { ix, acc, next -> ix.toInt() + acc + next }}")
    intArray.shuffle()
    println("shuffle(): ${intArray.contentToString()}")
    intArray.shuffle(Random(42))
    println("shuffle(Random(42)): ${intArray.contentToString()}")
    println(
        "single(): ${
            try {
                intArray.single()
            } catch (e: Exception) {
                e
            }
        }"
    )
    println("single { it == 10.convert<ssize_t>() }: ${intArray.single { it == 10.convert<ssize_t>() }}")
    println("singleOrNull(): ${intArray.singleOrNull()}")
    println("singleOrNull { it == 0.convert<ssize_t>() }: ${intArray.singleOrNull { it == 0.convert<ssize_t>() }}")
    println("slice(2..4): ${intArray.slice(2..4)}")
    println("slice(listOf(1, 3, 5)): ${intArray.slice(listOf(1, 3, 5))}")
    println("sliceArray(2..4).contentToString(): ${intArray.sliceArray(2..4).contentToString()}")
    println("sliceArray(listOf(1, 3, 5).contentToString()): ${intArray.sliceArray(listOf(1, 3, 5)).contentToString()}")
    println("sort(): ${intArray.sort().let { intArray }}")
    println("sort(1, 5): ${intArray.sort(1, 5).let { intArray }}")
    println("sortDescending(): ${intArray.sortDescending().let { intArray }}")
    println("sortDescending(1, 5): ${intArray.sortDescending(1, 5).let { intArray }}")
    println("sorted(): ${intArray.sorted()}")
    println("sortedArray(): ${intArray.sortedArray().contentToString()}")
    println("sortedArrayDescending(): ${intArray.sortedArrayDescending().contentToString()}")
    println("sortedBy(ssize_t::toString): ${intArray.sortedBy(ssize_t::toString)}")
    println("sortedByDescending(ssize_t::toString): ${intArray.sortedByDescending(ssize_t::toString)}")
    println("sortedDescending(): ${intArray.sortedDescending()}")
    println("sortedWith { a, b -> b.compareTo(a) }: ${intArray.sortedWith { a, b -> b.compareTo(a) }}")
    println("subtract(setOf(42.convert<ssize_t>())): ${intArray.subtract(setOf(42.convert<ssize_t>()))}")
    println("sum(): ${intArray.sum()}")
    println("sumBy(ssize_t::toInt): ${intArray.sumBy(ssize_t::toInt)}")
    println("sumByDouble { it.toDouble() }: ${intArray.sumByDouble { it.toDouble() }}")
    println("sumOf { it.toInt() }: ${intArray.sumOf { it.toInt() }}")
    println("sumOf { it.toLong() }: ${intArray.sumOf { it.toLong() }}")
    println("sumOf { it.toDouble() }: ${intArray.sumOf { it.toDouble() }}")
    println("sumOf { it.toInt() }: ${intArray.sumOf { it.toInt() }}")
    println("sumOf { it.toULong() }: ${intArray.sumOf { it.toULong() }}")
    println("take(3): ${intArray.take(3)}")
    println("takeLast(2): ${intArray.takeLast(2)}")
    println("takeLastWhile { it == 42.convert<ssize_t>() }: ${intArray.takeLastWhile { it == 42.convert<ssize_t>() }}")
    println("takeWhile { it < 10 }: ${intArray.takeWhile { it < 10 }}")
    println("toCollection(mutableSetOf()): ${intArray.toCollection(mutableSetOf())}")
    println("toHashSet(): ${intArray.toHashSet()}")
    println("toList(): ${intArray.toList()}")
    println("toMutableList(): ${intArray.toMutableList()}")
    println("toMutableSet(): ${intArray.toMutableSet()}")
    println("toSet(): ${intArray.toSet()}")
    println("toTypedArray(): ${intArray.toTypedArray().contentToString()}")
    println("union(listOf(100.convert<ssize_t>())): ${intArray.union(listOf(100.convert<ssize_t>()))}")
    println("withIndex().toList(): ${intArray.withIndex().toList()}")
    println("zip(supportArray): ${intArray.zip(supportArray)}")
    println("zip(supportArray) { my, their -> \"\$my\$their\"}: ${intArray.zip(supportArray) { my, their -> "$my$their" }}")
    println("zip(listOf(1, 2, 3)): ${intArray.zip(listOf(1, 2, 3))}")
    println(
        "zip(listOf(1, 2, 3)) { my, their -> \"\$my\$their\"}: ${
            intArray.zip(
                listOf(
                    1,
                    2,
                    3
                )
            ) { my, their -> "$my$their" }
        }"
    )
    println("zip(arrayOf(4, 5, 6)): ${intArray.zip(arrayOf(4, 5, 6))}")
    println(
        "zip(arrayOf(4, 5, 6)) { my, their -> \"\$my\$their\" }: ${
            intArray.zip(
                arrayOf(
                    4,
                    5,
                    6
                )
            ) { my, their -> "$my$their" }
        }"
    )

    /* deprecated */
    //    intArray.max()
    //    intArray.maxBy { -it }
    //    intArray.maxWith { s1, s2 -> s1.compareTo(s2)}
    //    intArray.min()
    //    intArray.minBy { it.toString() }
    //    intArray.minWith { s1, s2 -> s1.toString().compareTo(s2.toString())}

    /* doesn't exist for unsigned */
    println("average(): ${intArray.average()}")
}
