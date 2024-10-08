package cl.ravenhill.sumdigits

private const val TEN = 10

fun sumDigits(n: Int): Int {
    tailrec fun aux(n: Int, sum: Int): Int = if (n == 0) {
        sum
    } else {
        val lastDigit = n % TEN
        aux(n / TEN, sum + lastDigit)
    }
    return aux(n, 0)
}
