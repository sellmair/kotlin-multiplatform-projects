@file:OptIn(ExperimentalBlackHoleApi::class)

import androidx.benchmark.BlackHole
import androidx.benchmark.ExperimentalBlackHoleApi
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import org.junit.Rule
import kotlin.test.BeforeTest
import kotlin.test.Test

class FloatIsFiniteBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    val data = FloatArray(Int.MAX_VALUE - 0x7f000000)

    @BeforeTest
    fun setup() {
        println(System.getProperty("java.version"))
        println(System.getProperty("java.home"))
        for (i in data.indices) {
            data[i] = Float.fromBits(0x7f000000 + i)
        }
    }

    @Test
    fun kotlinStdlibIsFinite() {
        benchmarkRule.measureRepeated {
            data.forEach {
                BlackHole.consume(it.isFinite())
            }
        }
    }

    @Test
    fun fastIsFinite() {
        benchmarkRule.measureRepeated {
            data.forEach {
                BlackHole.consume(it.fastIsFinite())
            }
        }
    }

    @Test
    fun javaLangIsFinite() {
        benchmarkRule.measureRepeated {
            data.forEach {
                BlackHole.consume(it.javaLangIsFinite())
            }
        }
    }
}


@Suppress("NOTHING_TO_INLINE")
inline fun Float.fastIsFinite(): Boolean = (toRawBits() and 0x7fffffff) < 0x7f800000

@Suppress("NOTHING_TO_INLINE")
inline fun Float.javaLangIsFinite(): Boolean = java.lang.Float.isFinite(this)