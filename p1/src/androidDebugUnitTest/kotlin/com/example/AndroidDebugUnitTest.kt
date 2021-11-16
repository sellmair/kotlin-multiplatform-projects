package com.example

import kotlin.test.Test
import kotlin.test.assertEquals

class AndroidDebugUnitTest {
    @Test
    fun androidDebugUnitTest() {
        AndroidDebug.hello()
        assertEquals(2, 34)
    }
}
