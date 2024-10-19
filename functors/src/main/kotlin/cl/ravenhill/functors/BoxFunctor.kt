package cl.ravenhill.functors

object BoxFunctor {
    fun <A, B> Box<A>.map(f: (A) -> B) = Box(f(this.value))
}
