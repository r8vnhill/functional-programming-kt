package cl.ravenhill.either

fun <L, R> fold(
    either: Either<L, R>,
    left: (L) -> Unit,
    right: (R) -> Unit
) = when (either) {
    is Left -> left(either.value)
    is Right -> right(either.value)
}
