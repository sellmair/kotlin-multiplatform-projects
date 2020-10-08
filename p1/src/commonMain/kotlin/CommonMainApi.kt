import kotlin.properties.Delegates

object CommonMainApi {
    val nonLazyProperty = run {
        println("Using expect function: ${1f.toRawBits()}")
        println("non lazy")
    }

    val lazyProperty by lazy {
        println("lazy")
    }

    var observableProperty by Delegates.observable(1) { _, _, _ ->
        println("changed")
    }

    var notNullProperty by Delegates.notNull<String>()
}

val topLevelProperty = run {
    println("top level property")
}
