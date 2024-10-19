package cl.ravenhill.option

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class OptionTest : FreeSpec({
    "An Option" - {
        "when applying unit followed by flatMap" - {
            "should be the same as applying the function directly (left identity)" {
                checkAll(Arb.int()) { n ->
                    with(OptionMonad<Int>()) {
                        unit(n).flatMap { unit(it * 2) } shouldBe unit(n * 2)
                    }
                }
            }
        }
    }
})
