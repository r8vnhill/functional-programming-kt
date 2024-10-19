package cl.ravenhill.functors.function

/**
 * A functor for functions, allowing transformations over the result of a function.
 *
 * The `FunctionFunctor` class provides a `map` function that allows you to apply a transformation to the result of a
 * function of type `(T) -> R`. It enables functional composition, where the result of a function can be mapped and
 * further transformed by another function.
 *
 * ## Usage:
 * The `FunctionFunctor` class allows you to chain transformations over functions by mapping over their results.
 *
 * ### Example 1: Mapping Over a Function's Result
 * ```kotlin
 * val originalFunction: (Int) -> Int = { it * 2 }
 * val functor = FunctionFunctor<Int>()
 * val mappedFunction = functor.run {
 *     originalFunction.map { it + 3 }
 * }
 * println(mappedFunction(5)) // Outputs: 13 (originalFunction(5) = 10, then 10 + 3 = 13)
 * ```
 *
 * @param T The input type of the original function.
 */
class FunctionFunctor<T> {
    /**
     * Maps a function over the result of the original function.
     *
     * This function takes a function of type `(T) -> R` and a mapping function `(R) -> R`, and returns a new function
     * that applies the mapping function to the result of the original function.
     *
     * @param R The return type of the original function, and the type that the mapping function operates on.
     * @param f The mapping function that transforms the result of the original function.
     * @return A new function of type `(T) -> R` where the result has been transformed by the mapping function.
     */
    fun <R> ((T) -> R).map(f: (R) -> R): (T) -> R = { f(this(it)) }
}
