package com.example

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(TextView(this).apply {
            text = "Hello from KPM 👋 | Variant $variantName | This is OK."
        })
    }

    companion object {
        fun helloFromAndroid() {
            CommonMain()
            Log.d("android", "Android 🧡 Kotlin")
        }
    }
}
