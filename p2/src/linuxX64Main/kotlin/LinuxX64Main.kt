import kotlinx.cinterop.pointed
import kotlinx.cinterop.useContents
import withPosix.MyStruct

fun linuxX64Main() {
    workWithMyStruct(createMyStructFromNativeMain())
    withPosix.createMyStructPointer()!!.pointed
    withPosix.helloFromNative()
    withPosix.createMyStruct()
    withPosix.getFileStat().useContents { this }
}

fun workWithMyStruct(myStruct: MyStruct){
    myStruct.notAvailableOnMacos
}
