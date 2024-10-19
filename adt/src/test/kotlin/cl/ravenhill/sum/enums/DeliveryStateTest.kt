package cl.ravenhill.sum.enums

import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class DeliveryStateTest : FreeSpec({
    "A delivery state" - {
        "when handled" - {
            "should return a string representation" - {
                withData(
                    DeliveryState.PENDING to "Non-final state: Order is pending",
                    DeliveryState.PAID to "Non-final state: Order is paid",
                    DeliveryState.SHIPPED to "Non-final state: Order is shipped",
                    DeliveryState.DELIVERED to "Final state: Order is delivered",
                    DeliveryState.CANCELLED to "Final state: Order is cancelled"
                ) { (state, expected) ->
                    handleState(state) shouldBe expected
                }
            }
        }

        "when accessing its code" - {
            "should return the index of the state" - {
                withData(
                    DeliveryState.PENDING to 0,
                    DeliveryState.PAID to 1,
                    DeliveryState.SHIPPED to 2,
                    DeliveryState.DELIVERED to 3,
                    DeliveryState.CANCELLED to 4
                ) { (state, expected) ->
                    state.code shouldBe expected
                }
            }
        }
    }
})
