package cl.ravenhill.functional.fold

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.list
import io.kotest.property.checkAll

private fun add(a: Int, b: Int): Int = a + b

class FoldTest : FreeSpec({
    "A list of integers" - {
        "when folded with a function that sums the elements" - {
            "should return the sum of the elements" {
                checkAll(Arb.list(Arb.int())) { list ->
                    fold(list, 0, ::add) shouldBe list.sum()
                }
            }
        }
    }
})
