package cl.ravenhill.lambdas.destructuring

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class PairProcessingTest : FreeSpec({
    "A pair can be destructured by a lambda" {
        sumPair(3 to 4) shouldBe 7
        increasePairBy(3 to 4, 2) shouldBe (5 to 6)
    }
})
