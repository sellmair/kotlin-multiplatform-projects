import okio.FileSystem
import okio.Path.Companion.toPath
import kotlin.test.Test

class CommonTest {
    @Test
    fun `common test`() {
        "".toPath()
        error("YSLJD")
        //myExpectation(someSettings)
    }

    @Test
    fun `failing test`() {
        error("SHOUDL FAIL")
    }
}
