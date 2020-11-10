import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun useCoroutines() {
    GlobalScope.launch(Dispatchers.IO) {
        //
    }
}

