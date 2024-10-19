package cl.ravenhill.functors.result

/**
 * A sealed interface representing the result of an operation, which can either be a success or a failure.
 *
 * The `Result` interface is sealed, meaning that all possible subtypes are known at compile time. It is used to model
 * operations that can either complete successfully with a value (`Success`) or fail with an exception (`Failure`). By
 * using a sealed interface, the `Result` type ensures exhaustive handling of its subtypes in `when` expressions.
 *
 * ## Usage:
 * The `Result` interface can be used to represent the outcome of operations, with either a successful value or an
 * exception indicating failure.
 *
 * ### Example 1: Handling a Result in a `when` Expression
 * ```kotlin
 * val result: Result<Int> = Success(42)
 * when (result) {
 *     is Success -> println("Success: ${result.value}")
 *     is Failure -> println("Failure: ${result.exception.message}")
 * }
 * // Outputs: Success: 42
 * ```
 *
 * ### Example 2: Creating a Result Type
 * ```kotlin
 * val successResult: Result<String> = Success("Operation succeeded")
 * val failureResult: Result<String> = Failure(Exception("Operation failed"))
 * ```
 *
 * @param T The type of value in the case of a successful result.
 */
sealed interface Result<out T>
