package cl.ravenhill.product

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PairTest : FreeSpec({
    "Two ways of creating a pair" {
        Pair(1, true) shouldBe (1 to true)
    }
})
