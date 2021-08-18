actual interface CommonMainInterface {
    actual val propertyFromInterface: Int
}

actual class CommonMainImpl : CommonMainInterface {
    override val propertyFromInterface: Int = 42
    actual val propertyFromImpl: Int = 42
}