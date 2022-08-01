package org.jetbrains.sample

import java.util.concurrent.locks.ReentrantLock

object JvmMainOk {
    fun sayHello(): JvmMainOk = this

    init {
        val lock = ReentrantLock()
        check(lock.isFair)
    }
}