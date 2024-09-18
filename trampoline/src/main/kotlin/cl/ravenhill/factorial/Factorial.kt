package cl.ravenhill.factorial

import cl.ravenhill.trampoline.Done
import cl.ravenhill.trampoline.More
import cl.ravenhill.trampoline.Trampoline

fun factorial(n: Int, acc: Int = 1): Trampoline<Int> = if (n == 0) {
    Done(acc)
} else {
    More { factorial(n - 1, acc * n) }
}
