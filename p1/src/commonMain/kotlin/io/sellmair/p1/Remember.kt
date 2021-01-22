package io.sellmair.p1

fun brokenFunction(calculation: @SomeAnnotation(someProperty = true) () -> Any): Any = calculation()

fun workingFunction(calculation: @SomeAnnotation () -> Any): Any = calculation()