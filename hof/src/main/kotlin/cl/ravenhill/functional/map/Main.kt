package cl.ravenhill.functional.map

fun double(n: Int): Int = n * 2

fun square(n: Int): Int = n * n

fun main() {
    println(map(listOf(1, 2, 3, 4, 5), ::double))
    println(map(listOf(1, 2, 3, 4, 5), ::square))
}
