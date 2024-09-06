package org.jetbrains.kotlin.benchmark

import kotlinx.benchmark.*
import kotlinx.benchmark.State
import kotlin.random.Random

fun Double.alternativeIsFinite(): Boolean {
    return (toRawBits() and 0x7fffffff_ffffffffL) < 0x7ff00000_00000000L
}

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@State(Scope.Benchmark)
open class DoubleIsFiniteBenchmark {

    @Param("zero", "-Infinity", "+Infinity", "NaN")
    lateinit var value: String

    var double: Double = 0.0

    @Setup
    fun setup() {
        double = when (value) {
            "zero" -> 0.0
            "-Infinity" -> Double.NEGATIVE_INFINITY
            "+Infinity" -> Double.POSITIVE_INFINITY
            "NaN" -> Double.NaN
            else -> throw IllegalArgumentException("Unknown: $value")
        }
    }

    @Benchmark
    fun stdlib(): Boolean {
        return double.isFinite()
    }

    @Benchmark
    fun alternative1(): Boolean {
        return double.alternativeIsFinite()
    }
}

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@State(Scope.Benchmark)
open class DoubleIsFiniteAlternatingBenchmark {

    private val values = doubleArrayOf(
        0.0, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Random.nextDouble()
    )

    private var idx = 0

    fun next(): Double {
        val n = values[idx]
        idx = (idx + 1) % values.size
        return n
    }


    @Benchmark
    fun stdlib(): Boolean {
        return next().isFinite()
    }

    @Benchmark
    fun alternative1(): Boolean {
        return next().alternativeIsFinite()
    }
}


