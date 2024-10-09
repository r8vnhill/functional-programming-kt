package cl.ravenhill.functional.map

fun <T, R> map(
    list: List<T>,
    f: (T) -> R
): List<R> = if (list.isEmpty()) {
    emptyList()
} else {
    listOf(f(list.first())) + map(list.drop(1), f)
}
