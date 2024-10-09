package cl.ravenhill.product

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class TripleTest : FreeSpec({
    "A triple" - {
        "can be created" {
            with(Triple(1, true, "hello")) {
                first shouldBe 1
                second shouldBe true
                third shouldBe "hello"
            }
        }
    }
})
