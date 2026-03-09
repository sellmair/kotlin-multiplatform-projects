package org.jetbrains.sample.test

import org.junit.jupiter.api.Nested
import kotlin.test.Test

class ReproduceIssue {
    @Nested
    inner class ThisIsAVeryLongClassName {
        @Nested
        inner class ThisIsAVeryLongClassName1 {
            @Nested
            inner class ThisIsAVeryLongClassName2 {
                @Nested
                inner class ThisIsAVeryLongClassName3 {

                    @Nested
                    inner class ThisIsAVeryLongClassName4 {
                        @Test
                        fun thisIsAlsoARatherLongMethodName() {
                            println("Hello, world!")
                        }
                    }
                }
            }
        }
    }
}
