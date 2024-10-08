package cl.ravenhill.result

@Suppress("TooGenericExceptionCaught")
inline fun <T> runCatching(block: () -> T): Result<T> = try {
    Success(block())
} catch (e: Throwable) {
    Failure(e)
}

inline fun <T, U> fold(
    result: Result<T>,
    onFailure: (Throwable) -> U,
    onSuccess: (T) -> U
) = when (result) {
    is Failure -> onFailure(result.error)
    is Success -> onSuccess(result.value)
}