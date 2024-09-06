package org.jetbrains.kotlin.benchmark

import kotlinx.benchmark.*
import kotlinx.benchmark.State
import kotlin.random.Random

fun Float.alternativeIsFinite(): Boolean {
    return (toRawBits() and 0x7fffffff) < 0x7f800000
}

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@State(Scope.Benchmark)
open class IsFiniteBenchmark {

    @Param("zero", "-Infinity", "+Infinity", "NaN")
    lateinit var value: String

    var float: Float = 0f

    @Setup
    fun setup() {
        float = when (value) {
            "zero" -> 0f
            "-Infinity" -> Float.NEGATIVE_INFINITY
            "+Infinity" -> Float.POSITIVE_INFINITY
            "NaN" -> Float.NaN
            else -> throw IllegalArgumentException("Unknown: $value")
        }
    }

    @Benchmark
    fun stdlib(): Boolean {
        return float.isFinite()
    }

    @Benchmark
    fun alternative1(): Boolean {
        return float.alternativeIsFinite()
    }
}

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@State(Scope.Benchmark)
open class IsFiniteAlternatingBenchmark {

    private val values = floatArrayOf(
        0f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Random.nextFloat()
    )

    private var idx = 0

    fun next(): Float {
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


