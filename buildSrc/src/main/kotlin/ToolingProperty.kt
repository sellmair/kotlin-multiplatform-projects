import org.gradle.kotlin.dsl.typeOf
import kotlin.reflect.KProperty
import kotlin.reflect.full.findAnnotation

fun annotation(): ToolingProperty = ToolingProperty()
fun valuesAnnotation() : ToolingProperty = ToolingProperty()

class ToolingProperty {
    annotation class Scope(val title: String, val description: String = "")
    annotation class Value(val value: String, val title: String = "", val description: String = "")
    annotation class Values(val values: Array<String>, val title: String = "", val description: String = "")

    inline operator fun <reified T> getValue(thisRef: Any?, property: KProperty<*>): T {
        return when (val type = typeOf<T>()) {
            typeOf<String>() -> getStringValue(property) as T
            typeOf<List<String>>() -> getListValue(property) as T
            else -> error("Unsupported type: $type")
        }
    }

    fun getStringValue(property: KProperty<*>): String {
        return property.findAnnotation<Value>()?.value ?: error("Missing value")
    }

    fun getListValue(property: KProperty<*>): List<String> {
        return property.findAnnotation<Values>()?.values?.toList() ?: error("Missing value")
    }
}
