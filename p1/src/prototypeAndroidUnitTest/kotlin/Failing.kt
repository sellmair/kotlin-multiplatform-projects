class Failing {
    @kotlin.test.Test
    fun expectedToFail() {
        kotlin.test.fail("Fail!")
    }
}

class Succeeding {
    @kotlin.test.Test
    fun expectedToSucceed() {
        println("Success!")
    }
}