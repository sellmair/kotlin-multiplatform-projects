package com.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arkivanov.mvikotlin.core.store.Store

actual val variantName: String = "debug"

class A: AppCompatActivity() {
    internal interface SomeStore : Store<Unit, Unit, Nothing> {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}