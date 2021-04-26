@file:Suppress("unused")

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun commonMainUnresolved() = GlobalScope.launch(Dispatchers.IO) {

}

fun commonMainResolved() = GlobalScope.launch(Dispatchers.Main) {

}