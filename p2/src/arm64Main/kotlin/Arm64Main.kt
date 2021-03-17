import dummy.DummyStruct
import dummy.OtherStruct

actual fun sum(dummy: DummyStruct): Double {
    return dummy.myShort + dummy.myInteger + dummy.myLong + dummy.myFloat + dummy.myDouble
}

actual fun sum(otherStruct: OtherStruct): Double {
    return sum(otherStruct.dummy1) + sum(otherStruct.dummy2)
}

actual fun DummyStruct.reset() {
    this.myShort = 0
    this.myInteger = 0
    this.myLong = 0
    this.myFloat = 0f
    this.myDouble = 0.0
}
