package com.example

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TextView(this).apply {
            text = "🥸 ${variantName()}"
        })
    }

    companion object {
        fun helloFromAndroid() {
            CommonMain.useCommonMain()
            Log.d("android", "Android 🧡 Kotlin")
        }
    }
}
