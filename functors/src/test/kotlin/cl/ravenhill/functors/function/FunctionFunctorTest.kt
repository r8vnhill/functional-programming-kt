package cl.ravenhill.functors.function

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class FunctionFunctorTest : FreeSpec({
    "A function functor" - {
        "when mapped with the identity function" - {
            "should return the same function" {
                with(FunctionFunctor<Int>()) {
                    val function = { x: Int -> x * 2 }
                    val identity = function.map { it }
                    identity(420) shouldBe function(420)
                }
            }
        }

        "when composed with two functions" - {
            "should return the same function as the composition" {
                with(FunctionFunctor<Int>()) {
                    val function = { x: Int -> x * 2 }
                    val composition = function.map { it + 1 }.map { it * 2 }
                    val composed = function.map { (it + 1) * 2 }
                    composition(420) shouldBe composed(420)
                }
            }
        }
    }
})
