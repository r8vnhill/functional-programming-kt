package cl.ravenhill.functional.filter

fun filter(list: List<Int>, f: (Int) -> Boolean): List<Int> =
    if (list.isEmpty()) {
        emptyList()
    } else {
        val head = list.first()
        val tail = list.drop(1)
        if (f(head)) {
            listOf(head) + filter(tail, f)
        } else {
            filter(tail, f)
        }
    }
