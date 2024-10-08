/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

@file:Suppress("PackageDirectoryMismatch")

package kotlinx.coroutines.external

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.debug.internal.AbstractStaticDebugProbes
import kotlin.coroutines.Continuation

/*
This class will not be shipped in the final jar and is expected to be provided statically
by builds, engaging debug probes
 */
@OptIn(DelicateCoroutinesApi::class)
object StaticDebugProbes : AbstractStaticDebugProbes() {
    override fun <T> probeCoroutineCreated(completion: Continuation<T>): Continuation<T> {
        /** implementation of this function is replaced statically for advanced builds */
        println("probeCoroutineCreated")
        return super.probeCoroutineCreated(completion)
    }

    override fun probeCoroutineResumed(frame: Continuation<*>) {
        println("probeCoroutineResumed")
        super.probeCoroutineResumed(frame)
    }

    override fun probeCoroutineSuspended(frame: Continuation<*>) {
        println("probeCoroutineSuspended")
        super.probeCoroutineSuspended(frame)
    }

    fun print() {
        dumpCoroutines(System.out)
    }
}
