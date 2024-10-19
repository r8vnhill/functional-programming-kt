package cl.ravenhill.functors.result

/**
 * Represents a failure result containing an exception.
 *
 * The `Failure` class is a specific type of `Result` used to encapsulate an exception when an operation fails. It holds
 * the `Throwable` that caused the failure, providing information about the error.
 *
 * This class is part of the `Result` type hierarchy, where `Failure` represents an unsuccessful operation. It
 * implements `Result<Nothing>`, indicating that it does not hold a valid result value.
 *
 * ## Usage:
 * Use `Failure` to signal an error or exception when working with operations that may fail.
 *
 * ### Example 1: Creating a Failure Result
 * ```kotlin
 * val failure = Failure(IllegalArgumentException("Invalid argument"))
 * println(failure.exception.message) // Outputs: Invalid argument
 * ```
 *
 * ### Example 2: Handling a Failure in a Result
 * ```kotlin
 * val result: Result<Int> = Failure(NumberFormatException("Invalid number"))
 * when (result) {
 *     is Failure -> println("Error: ${result.exception.message}")
 *     else -> println("Success")
 * }
 * // Outputs: Error: Invalid number
 * ```
 *
 * @property exception The exception that caused the failure.
 */
data class Failure(val exception: Throwable) : Result<Nothing>
