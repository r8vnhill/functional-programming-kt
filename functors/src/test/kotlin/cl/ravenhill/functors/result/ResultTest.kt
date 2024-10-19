package cl.ravenhill.functors.result

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.choice
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class ResultTest : FreeSpec({
    "Given a result" - {
        "when mapping the identity function" - {
            "should return the same result" {
                checkAll(
                    Arb.choice(
                        Arb.int().map { Success(it) },
                        arbThrowable().map { Failure(it) }
                    )
                ) { result ->
                    with(ResultFunctor<Int>()) {
                        result.map { it } shouldBe result
                    }
                }
            }
        }

        "when composing two functions" - {
            "should be the same as applying the composed function once" {
                checkAll(
                    Arb.choice(
                        Arb.int().map { Success(it) },
                        arbThrowable().map { Failure(it) }
                    )
                ) { result ->
                    val f = { x: Int -> x + 1 }
                    val g = { x: Int -> x * 2 }

                    with(ResultFunctor<Int>()) {
                        result.map(f).map(g) shouldBe result.map { g(f(it)) }
                    }
                }
            }
        }
    }
})

private fun arbThrowable() = Arb.string().map { Throwable(it) }
