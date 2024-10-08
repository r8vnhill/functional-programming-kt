package cl.ravenhill.result

data class Success<out T>(val value: T) : Result<T>()
