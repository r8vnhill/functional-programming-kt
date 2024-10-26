package cl.ravenhill.functional.map

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

private fun double(n: Int): Int = n * 2

class MapTest : FreeSpec({
    "A list of integers" - {
        "when mapped with a function that doubles the elements" - {
            "should return a list which sum is twice the original sum" {
                checkAll(Arb.list(Arb.int())) { list ->
                    map(list, ::double).sum() shouldBe list.sum() * 2
                }
            }
        }
    }
})
