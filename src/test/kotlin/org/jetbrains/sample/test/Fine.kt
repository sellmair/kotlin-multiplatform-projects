package org.jetbrains.sample.test

import kotlin.test.Test

class Fine {
    class ThisIsAVeryLongClassName {
        class ThisIsAVeryLongClassName1 {
            class ThisIsAVeryLongClassName2 {
                class ThisIsAVeryLongClassName3 {
                    class ThisIsAVeryLongClassName4 {
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
