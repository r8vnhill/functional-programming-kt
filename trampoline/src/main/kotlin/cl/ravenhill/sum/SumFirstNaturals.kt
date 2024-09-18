package cl.ravenhill.sum

import cl.ravenhill.trampoline.Done
import cl.ravenhill.trampoline.More
import cl.ravenhill.trampoline.Trampoline

fun sumFirstNaturals(n: Int, acc: Int = 0): Trampoline<Int> =
    if (n == 0) {
        Done(acc)
    } else {
        More { sumFirstNaturals(n - 1, acc + n) }
    }
