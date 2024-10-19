package cl.ravenhill.option

class OptionMonad<T> {
    fun unit(value: T): Option<T> = Some(value)

    fun <R> Option<T>.flatMap(f: (T) -> Option<R>): Option<R> = when(this) {
        is None -> None
        is Some -> f(value)
    }
}
