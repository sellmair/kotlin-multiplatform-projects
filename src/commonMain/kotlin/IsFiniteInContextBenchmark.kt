package org.jetbrains.kotlin.benchmark

import kotlinx.benchmark.*
import kotlin.random.Random


@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@State(Scope.Benchmark)
open class IsFiniteInContextBenchmark {
    private val values = FloatArray(128) { if (it == 0) Float.POSITIVE_INFINITY else Random.nextFloat() }

    @Benchmark
    fun stdlib(): Float {
        var sum = 0.0f
        for (v in values) {
            sum += if (v.isFinite()) v else 0.0f
        }
        return sum
    }

    @Benchmark
    fun alternative1(): Float {
        var sum = 0.0f
        for (v in values) {
            sum += if (v.alternativeIsFinite()) v else 0.0f
        }
        return sum
    }
}