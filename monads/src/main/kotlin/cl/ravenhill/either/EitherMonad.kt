package cl.ravenhill.either

object EitherMonad {
    fun <L, R> pure(r: R): Either<L, R> = Right(r)
    fun <L, R, T> Either<L, R>.flatMap(f: (R) -> Either<L, T>): Either<L, T> = when (this) {
        is Left -> this
        is Right -> f(value)
    }
}
