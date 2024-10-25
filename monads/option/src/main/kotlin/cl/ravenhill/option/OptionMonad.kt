package cl.ravenhill.option

object OptionMonad {
    fun <A> pure(a: A): Option<A> = Some(a)

    fun <A, B> Option<A>.flatMap(f: (A) -> Option<B>): Option<B> =
        when (this) {
            is Some -> f(value)
            None -> None
        }
}
