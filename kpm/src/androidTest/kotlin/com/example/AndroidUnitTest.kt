package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test
import kotlin.test.assertEquals

class AndroidUnitTest {
    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun testContextPackageName() {
        assertEquals("com.examples", context.packageName)
    }
}
