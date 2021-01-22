import io.sellmair.p1.SomeAnnotation

fun <T> localRemember(calculation: @SomeAnnotation(someProperty = true) () -> T): T = calculation()
