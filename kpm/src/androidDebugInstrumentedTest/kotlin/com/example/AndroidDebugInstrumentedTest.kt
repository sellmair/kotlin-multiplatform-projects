package com.example

import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class AndroidDebugInstrumentedTest {
    @Test
    fun runningOnDevice() {
        AndroidInstrumentedTest()
    }
}
