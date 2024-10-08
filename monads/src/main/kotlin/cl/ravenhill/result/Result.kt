package cl.ravenhill.result

sealed class Result<out T> {
    inline fun <U> flatMap(f: (T) -> Result<U>) = when (this) {
        is Failure -> this
        is Success -> f(value)
    }

    companion object {
        fun <T> pure(value: T) = Success(value)
    }
}
