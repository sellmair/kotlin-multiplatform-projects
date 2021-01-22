package io.sellmair.p1

@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY, // (DEPRECATED)
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.TYPE
)
annotation class SomeAnnotation(
    val someProperty: Boolean = false
)
