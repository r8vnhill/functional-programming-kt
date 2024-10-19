package cl.ravenhill.sum.enums

enum class DeliveryState(private val description: String, val code: Int) {
    PENDING("Order is pending", 0),
    PAID("Order is paid", 1),
    SHIPPED("Order is shipped", 2),
    DELIVERED("Order is delivered", 3),
    CANCELLED("Order is cancelled", 4);

    fun signal(): String = description

    val isFinal: Boolean
        get() = this == DELIVERED || this == CANCELLED
}

fun handleState(state: DeliveryState) = if (state.isFinal) {
    "Final state: ${state.signal()}"
} else {
    "Non-final state: ${state.signal()}"
}
