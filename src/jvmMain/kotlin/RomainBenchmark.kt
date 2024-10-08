package bm

import kotlinx.benchmark.*
import org.openjdk.jmh.annotations.Fork

@State(Scope.Benchmark)
open class FloatState {
    val data = FloatArray(Int.MAX_VALUE - 0x7f000000)

    @Setup
    fun setup() {
        println(System.getProperty("java.version"))
        println(System.getProperty("java.home"))
        for (i in data.indices) {
            data[i] = Float.fromBits(0x7f000000 + i)
        }
    }
}

@Warmup(iterations = 5, timeUnit = BenchmarkTimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(BenchmarkTimeUnit.MILLISECONDS)
open class KotlinBenchmark {
    @Benchmark
    fun isFinite(state: FloatState): Boolean {
        var r = false
        for (f in state.data) {
            r = r or f.isFinite()
        }
        return r
    }

    @Benchmark
    fun fastIsFinite(state: FloatState): Boolean {
        var r = false
        for (f in state.data) {
            r = r or f.fastIsFinite()
        }
        return r
    }

    @Benchmark
    fun javaLangIsFinite(state: FloatState): Boolean {
        var r = false
        for (f in state.data) {
            r = r or f.javaLangIsFinite()
        }
        return r
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun Float.fastIsFinite(): Boolean = (toRawBits() and 0x7fffffff) < 0x7f800000

@Suppress("NOTHING_TO_INLINE")
inline fun Float.javaLangIsFinite(): Boolean = java.lang.Float.isFinite(this)