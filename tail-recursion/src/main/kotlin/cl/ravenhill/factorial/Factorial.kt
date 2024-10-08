package cl.ravenhill.factorial

tailrec fun factorial(n: Int, acc: Int): Int =
    if (n == 0) {
        acc
    } else {
        factorial(n - 1, acc * n)
    }
