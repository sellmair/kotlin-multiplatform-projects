import kotlin.test.Test
import kotlin.test.assertEquals

class MyCommonTest {
    @Test
    fun myTest() {
        assertEquals(42, myExpectFunctionInCommonTest())
    }
}

expect fun myExpectFunctionInCommonTest() : Int