package cl.ravenhill.functors.result

/**
 * A functor for working with `Result` types, providing utilities for mapping and folding over results.
 *
 * The `ResultFunctor` class offers functions to work with `Result` types, allowing you to apply transformations
 * using `map`, handle success and failure cases with `fold`, and execute code blocks safely using `runCatching`.
 * It handles both `Success` and `Failure` scenarios within a `Result` type.
 *
 * ## Usage:
 * This class enables functional transformations on `Result` values, similar to how functors work in functional
 * programming. You can map over successful results, fold over both success and failure cases, and safely run code that
 * may throw exceptions.
 *
 * ### Example 1: Mapping Over a Result
 * ```kotlin
 * val result = Success(2)
 * val mappedResult = ResultFunctor<Int>().run {
 *     result.map { it * 2 }
 * }
 * println(mappedResult) // Outputs: Success(4)
 * ```
 *
 * ### Example 2: Folding Over a Result
 * ```kotlin
 * val result = Failure<Int>(IllegalArgumentException("Invalid argument"))
 * val outcome = ResultFunctor<Int>().run {
 *     result.fold(
 *         onFailure = { "Error: ${it.message}" },
 *         onSuccess = { "Success: $it" }
 *     )
 * }
 * println(outcome) // Outputs: Error: Invalid argument
 * ```
 *
 * ### Example 3: Using `runCatching` to Safely Execute Code
 * ```kotlin
 * val result = ResultFunctor<String>().runCatching {
 *     "This is a successful result"
 * }
 * println(result) // Outputs: Success(This is a successful result)
 * ```
 *
 * @param T The type of the value contained within the `Result`.
 */
class ResultFunctor<T> {

    /**
     * Maps a function over a successful result, transforming the contained value. If the result is a failure, the
     * failure is propagated unchanged.
     *
     * @param R The type of the value returned by the mapping function.
     * @param f The function to apply to the contained value if the result is successful.
     * @return A new `Result` containing the transformed value if successful, or the original failure if unsuccessful.
     */
    fun <R> Result<T>.map(f: (T) -> R): Result<R> = when(this) {
        is Failure -> this
        is Success -> Success(f(value))
    }

    /**
     * Maps a function over a failure result, transforming the exception.
     *
     * The `mapFailure` function is an extension function for the `Result` type that applies a transformation function
     * to the exception of a `Failure`. If the result is a `Success`, it remains unchanged. This is useful for
     * transforming the exception into a more specific type or adding context to the error.
     *
     * @param R The type of the transformed exception.
     * @param f The function to apply to the exception in case of a `Failure`.
     * @return A `Result<T>` where the exception has been transformed if it was a failure, or the original `Success` if it was successful.
     */
    fun <R : Throwable> Result<T>.contraMap(f: (Throwable) -> R): Result<T> = when(this) {
        is Failure -> Failure(f(exception))
        is Success -> this
    }

    /**
     * Folds over a `Result`, applying one of two functions depending on whether the result is a success or failure.
     *
     * @param R The type of the value returned by the folding functions.
     * @param onFailure The function to apply if the result is a failure.
     * @param onSuccess The function to apply if the result is a success.
     * @return The result of either `onFailure` or `onSuccess` depending on the outcome.
     */
    fun <R> Result<T>.fold(onFailure: (Throwable) -> R, onSuccess: (T) -> R): R = when(this) {
        is Failure -> onFailure(exception)
        is Success -> onSuccess(value)
    }

    /**
     * Executes a block of code and wraps the result in a `Result`, catching any exceptions that occur.
     *
     * @param block The code block to execute.
     * @return A `Success` result if the block completes without exception, or a `Failure` result if an exception is thrown.
     */
    fun runCatching(block: () -> T): Result<T> = try {
        Success(block())
    } catch (e: Throwable) {
        Failure(e)
    }
}
