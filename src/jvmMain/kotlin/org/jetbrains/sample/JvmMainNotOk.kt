package org.jetbrains.sample
 // when uncommented: Should fail ./gradlew animalsnifferMain
import java.util.stream.Stream

/*
object JvmMainNotOk {
    fun use(stream: Stream<String>) = stream.map { "" }.filter { true }

    init {
        Stream.empty<String>()
            .map { "" }
            .filter { true }
    }
}
 */
