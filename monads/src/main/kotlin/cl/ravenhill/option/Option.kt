package cl.ravenhill.option

sealed class Option<out A> {
    companion object {
        fun <T> pure(value: T) = Some(value)
    }
}

fun <T> getOrElse(option: Option<T>, default: T) = when (option) {
    is None -> default
    is Some -> option.value
}
