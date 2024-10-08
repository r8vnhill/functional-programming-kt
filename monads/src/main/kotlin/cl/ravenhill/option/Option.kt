package cl.ravenhill.option

sealed class Option<out A> {
    inline fun <B> flatMap(f: (A) -> Option<B>) = when (this) {
        is None -> this
        is Some -> f(value)
    }

    companion object {
        fun <T> pure(value: T) = Some(value)
    }
}

fun <T> getOrElse(option: Option<T>, default: T) = when (option) {
    is None -> default
    is Some -> option.value
}

fun <T, U> map(option: Option<T>, f: (T) -> U) = option.flatMap {
    Option.pure(f(it))
}
