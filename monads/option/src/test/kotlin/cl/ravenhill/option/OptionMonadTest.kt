package cl.ravenhill.option

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class OptionMonadTest : FreeSpec({
    "Given a box monad" - {
        // Left identity
        "when wrapping a value in the monadic context" - {
            ("then chaining a function should be the same as applying the " +
                    "function to the value"){
                checkAll(Arb.int(), Arb.int()) { a, b ->
                    OptionMonad.run {
                        val f: (Int) -> Option<Int> = { pure(it * b) }
                        pure(a).flatMap(f) shouldBe f(a)
                    }
                }
            }
        }

        // Right identity
        "when chaining a function that returns the monadic context" - {
            ("then the result should be the same as the original monadic " +
                    "context") {
                checkAll(Arb.int()) { a ->
                    OptionMonad.run {
                        pure(a).flatMap { pure(it) } shouldBe pure(a)
                    }
                }
            }
        }

        // Associativity
        "when chaining two functions" - {
            ("then the result should be the same as chaining the result of " +
                    "the first function with the second") {
                checkAll(Arb.int(), Arb.int(), Arb.int()) { a, b, c ->
                    OptionMonad.run {
                        val f: (Int) -> Option<Int> = { pure(it * b) }
                        val g: (Int) -> Option<Int> = { pure(it + c) }
                        pure(a).flatMap(f).flatMap(g) shouldBe
                                pure(a).flatMap { f(it).flatMap(g) }
                    }
                }
            }
        }
    }
})
