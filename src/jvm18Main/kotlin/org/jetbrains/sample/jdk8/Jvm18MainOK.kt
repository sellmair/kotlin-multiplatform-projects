package org.jetbrains.sample.jdk8

import org.jetbrains.sample.JvmMainOk
import java.util.stream.Stream

object Jvm18MainOk {
    fun use(stream: Stream<String>) = stream.map { "" }.filter { true }

    init {
        Stream.empty<String>()
            .map { "" }
            .filter { true }

        JvmMainOk.sayHello()
    }
}