package cl.ravenhill.functors.function

class FunctionFunctor<T> {
    fun <A, B> ((A) -> T).map(f: (A) -> B) = { x: A -> this(f(x)) }
}
