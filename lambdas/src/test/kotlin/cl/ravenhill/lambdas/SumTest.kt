package cl.ravenhill.lambdas

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class SumTest : FreeSpec({
    "An add function" - {
        "can sum two numbers" {
            add(3, 4) shouldBe 7
        }
    }
})
