package cl.ravenhill.either

data class Left<L>(val value: L) : Either<L, Nothing>()
