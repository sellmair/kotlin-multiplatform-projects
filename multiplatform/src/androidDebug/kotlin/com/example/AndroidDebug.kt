package com.example

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity

object AndroidDebug {
    fun x(activity: AppCompatActivity, other: Activity) {
        AndroidMain.x()
        MainActivity.helloFromAndroid()
        activity.supportActionBar
        other.actionBar
    }

    fun hello() = Unit
}
