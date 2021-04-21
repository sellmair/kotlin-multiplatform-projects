import kotlin.reflect.KProperty1

class CommonMain {
    val x: KProperty1<List<*>, Int> = List<*>::size
}
