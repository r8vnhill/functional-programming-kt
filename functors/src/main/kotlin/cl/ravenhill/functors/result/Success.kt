package cl.ravenhill.functors.result

/**
 * Represents a successful result containing a value.
 *
 * The `Success` class is a specific type of `Result` used to encapsulate a successful operation's result. It holds a
 * value of type `T`, indicating the outcome of a successful operation.
 *
 * This class is part of the `Result` type hierarchy, where `Success` represents a successful outcome.
 *
 * ## Usage:
 * Use `Success` to signal that an operation completed successfully and to hold the resulting value.
 *
 * ### Example 1: Creating a Success Result
 * ```kotlin
 * val success = Success(42)
 * println(success.value) // Outputs: 42
 * ```
 *
 * ### Example 2: Handling a Success in a Result
 * ```kotlin
 * val result: Result<Int> = Success(100)
 * when (result) {
 *     is Success -> println("Success: ${result.value}")
 *     else -> println("Failure")
 * }
 * // Outputs: Success: 100
 * ```
 *
 * @param T The type of the value held by this `Success` result.
 * @property value The value representing the successful result.
 */
data class Success<out T>(val value: T) : Result<T>
