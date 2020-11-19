import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun alsoUseCoroutines() = GlobalScope.launch(Dispatchers.IO) {

}