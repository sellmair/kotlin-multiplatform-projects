import dummy.DummyStruct
import dummy.OtherStruct
import dummy.createDummyStruct
import dummy.createOtherStruct
import kotlinx.cinterop.*

fun useDummy(): Double {
    memScoped {
        alloc<DummyStruct> {
            myShort = 0
            myInteger = 1
            myLong = 2
            myFloat = 0.3f
            myDouble = 0.4
        }
    }

    val dummy: CPointer<DummyStruct> = createDummyStruct() ?: return 0.0
    val other: CValue<OtherStruct> = createOtherStruct()
    return sum(dummy.pointed) + other.useContents { sum(this) }
}

expect fun sum(otherStruct: OtherStruct): Double

expect fun sum(dummy: DummyStruct): Double

expect fun DummyStruct.reset()
