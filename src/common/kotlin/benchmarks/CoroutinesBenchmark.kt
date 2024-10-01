package benchmarks

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.BenchmarkTimeUnit
import kotlinx.benchmark.Mode
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Measurement
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Warmup
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine


@State(Scope.Benchmark)
open class MyBenchmark {

    private val emptyContinuation = Continuation<Unit>(EmptyCoroutineContext) {}

    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
    @Warmup(iterations = 3, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
    @Measurement(iterations = 5, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
    @Benchmark
    fun createCoroutine() {
        ::suspendFoo.createCoroutine(emptyContinuation)
    }


    @BenchmarkMode(Mode.SingleShotTime)
    @OutputTimeUnit(BenchmarkTimeUnit.NANOSECONDS)
    @Warmup(iterations = 20, time = 500, timeUnit = BenchmarkTimeUnit.MILLISECONDS)
    @Measurement(iterations = 20, time = 1, timeUnit = BenchmarkTimeUnit.SECONDS)
    @Benchmark
    fun createCoroutineCold() {
        ::suspendFoo.createCoroutine(emptyContinuation)
    }
}

private suspend fun suspendFoo() {

}