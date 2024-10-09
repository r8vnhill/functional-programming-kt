package cl.ravenhill.functional.map

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

private fun double(n: Int): Int = n * 2

private fun square(n: Int): Int = n * n

class MapTest : FreeSpec({
    "A map function" - {
        "can double the elements" {
            map(listOf(1, 2, 3, 4, 5), ::double) shouldBe listOf(2, 4, 6, 8, 10)
        }
        "can square the elements" {
            map(listOf(1, 2, 3, 4, 5), ::square) shouldBe listOf(1, 4, 9, 16, 25)
        }
    }
})
