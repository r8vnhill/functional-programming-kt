package cl.ravenhill.either

data class Right<R>(val value: R) : Either<Nothing, R>()
