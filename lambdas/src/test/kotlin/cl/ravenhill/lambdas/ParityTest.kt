package cl.ravenhill.lambdas

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ParityTest : FreeSpec({
    "A list can be filtered by parity" {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        numbers.filter { it % 2 == 0 } shouldBe listOf(2, 4, 6, 8, 10)
    }
})
