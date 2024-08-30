package org.jetbrains.kotlin.benchmark

import kotlinx.benchmark.*
import kotlinx.benchmark.State

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@State(Scope.Benchmark)
open class IsFiniteBenchmark {

    @Param("zero", "-Infinity", "+Infinity", "NaN")
    lateinit var value: String

    var float: Float = 0f

    @Setup
    fun setup() {
        float = when(value) {
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
        return (float.toRawBits() and 0x7fffffff) < 0x7f800000
    }
}
