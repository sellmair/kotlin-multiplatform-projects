package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test
import kotlin.test.assertEquals

class AndroidUnitTest {

    @Test
    fun testContextPackageName() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assertEquals("com.examples", context.packageName)
    }
}
