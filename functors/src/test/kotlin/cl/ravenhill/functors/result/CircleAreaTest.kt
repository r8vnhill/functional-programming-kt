package cl.ravenhill.functors.result

import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.property.Arb
import io.kotest.property.arbitrary.negativeInt
import io.kotest.property.checkAll

class CircleAreaTest : FreeSpec({
    "Given a radius" - {
        "when calculating the area of a circle" - {
            "should return a success if the radius is non-negative" - {
                withData(
                    0 to 0.0,
                    1 to 3.141592653589793,
                    2 to 12.566370614359172,
                    3 to 28.274333882308138
                ) { (radius, expected) ->
                    with(ResultFunctor<Double>()) {
                        circleArea(radius)
                            .map { it shouldBe expected }
                            .shouldBeInstanceOf<Success<Double>>()
                            .contraMap { it }
                            .shouldBeInstanceOf<Success<Double>>()
                    }
                }
            }

            "should return a failure if the radius is negative" {
                checkAll(Arb.negativeInt()) { radius ->
                    with(ResultFunctor<Double>()) {
                        circleArea(radius)
                            .map { it }
                            .shouldBeInstanceOf<Failure>()
                            .contraMap {
                                it shouldHaveMessage "Radius must be non-negative"
                                it
                            }.shouldBeInstanceOf<Failure>()
                    }
                }
            }
        }
    }
})
