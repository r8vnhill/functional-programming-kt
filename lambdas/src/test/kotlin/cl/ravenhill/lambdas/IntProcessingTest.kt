package cl.ravenhill.lambdas

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class IntProcessingTest : FreeSpec({
    "Two integers can be combined with an add operation" {
        processInts(3, 4) { a, b -> a + b } shouldBe 7
    }
})
