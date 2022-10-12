import org.gradle.kotlin.dsl.typeOf
import kotlin.reflect.KProperty
import kotlin.reflect.full.findAnnotation

fun annotation(): ToolingProperty = ToolingProperty()
fun valuesAnnotation(): ToolingProperty = ToolingProperty()

class ToolingProperty {
    object Semantics {
        annotation class Dependencies
    }

    annotation class Scope(val title: kotlin.String, val description: kotlin.String = "")
    annotation class String(
        val value: kotlin.String,
        val title: kotlin.String = "",
        val description: kotlin.String = ""
    )

    annotation class List(
        val values: Array<kotlin.String>,
        val title: kotlin.String = "",
        val description: kotlin.String = ""
    )

    inline operator fun <reified T> getValue(thisRef: Any?, property: KProperty<*>): T {
        return when (val type = typeOf<T>()) {
            typeOf<kotlin.String>() -> getStringValue(property) as T
            typeOf<kotlin.collections.List<kotlin.String>>() -> getListValue(property) as T
            else -> error("Unsupported type: $type")
        }
    }

    fun getStringValue(property: KProperty<*>): kotlin.String {
        return property.findAnnotation<String>()?.value ?: error("Missing value")
    }

    fun getListValue(property: KProperty<*>): kotlin.collections.List<kotlin.String> {
        return property.findAnnotation<List>()?.values?.toList() ?: error("Missing value")
    }
}
