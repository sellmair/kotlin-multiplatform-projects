package io.sellmair.p1

inline fun <T> remember(calculation: @SomeAnnotation(someProperty = true) () -> T): T = calculation()
