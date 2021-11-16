package com.example

object AndroidMain {
    fun x(): String {
        CommonMain.useCommonMain()
        MainActivity.helloFromAndroid()
        return ""
    }
}
