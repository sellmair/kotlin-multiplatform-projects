import org.junit.Test

class AndroidAndroidTest {
    @Test
    fun runTest() {
        JvmTestApi.lazyProperty
        CommonMainApi.nonLazyProperty
        CommonMainApi.lazyProperty
        CommonMainApi.observableProperty = 2
        CommonMainApi.notNullProperty = ""
    }
}
