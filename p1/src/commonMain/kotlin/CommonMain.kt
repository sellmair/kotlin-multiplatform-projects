expect interface CommonMainInterface {
    val propertyFromInterface: Int
}

expect class CommonMainImpl : CommonMainInterface {
    val propertyFromImpl: Int
}