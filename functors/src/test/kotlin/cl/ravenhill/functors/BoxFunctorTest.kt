package cl.ravenhill.functors

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class BoxFunctorTest : FreeSpec({
    "Given a generic box" - {
        "when mapping the identity function" - {
            "should return the same box" {
                checkAll(Arb.int()) { value ->
                    val box = Box(value)
                    with(BoxFunctor) {
                        box.map { it } shouldBe box
                    }
                }
            }
        }

        "when composing two functions" - {
            "should be the same as applying the composed function once" {
                checkAll(Arb.int()) { value ->
                    val box = Box(value)
                    val f = { x: Int -> x + 1 }
                    val g = { x: Int -> x * 2 }

                    with(BoxFunctor) {
                        box.map(f).map(g) shouldBe box.map { g(f(it)) }
                    }
                }
            }
        }
    }
})
