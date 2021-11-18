package com.example

object AndroidInstrumentedTest {
    operator fun invoke(): Unit = kotlin.test.fail("HELLO")
}
