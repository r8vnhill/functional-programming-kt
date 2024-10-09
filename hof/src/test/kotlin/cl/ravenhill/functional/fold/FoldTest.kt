package cl.ravenhill.functional.fold

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

private fun add(a: Int, b: Int): Int = a + b

private fun multiply(a: Int, b: Int): Int = a * b

class FoldTest : FreeSpec({
    "A fold function" - {
        "can sum the elements" {
            fold(listOf(1, 2, 3, 4, 5), 0, ::add) shouldBe 15
        }
        "can multiply the elements" {
            fold(listOf(1, 2, 3, 4, 5), 1, ::multiply) shouldBe 120
        }
    }
})
