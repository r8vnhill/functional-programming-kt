package cl.ravenhill

data class Monad<T>(val value: T) {
    inline fun <R> flatMap(f: (T) -> Monad<R>): Monad<R> = f(value)
    companion object {
        fun <T> pure(value: T): Monad<T> = Monad(value)
    }
}
