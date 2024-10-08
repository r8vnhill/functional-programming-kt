package cl.ravenhill.result

data class Failure(val error: Throwable) : Result<Nothing>()
