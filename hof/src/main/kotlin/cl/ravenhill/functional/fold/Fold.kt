package cl.ravenhill.functional.fold

fun <T, R> fold(list: List<T>, initial: R, combine: (R, T) -> R): R =
    if (list.isEmpty()) {
        initial
    } else {
        val first = list.first()
        val rest = list.drop(1)
        val newAcc = combine(initial, first)
        fold(rest, newAcc, combine)
    }