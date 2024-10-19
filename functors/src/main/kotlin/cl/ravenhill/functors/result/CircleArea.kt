package cl.ravenhill.functors.result

import kotlin.math.PI

fun circleArea(radius: Int): Result<Double> = if (radius < 0) {
    Failure(IllegalArgumentException("Radius must be non-negative"))
} else {
    Success(PI * radius * radius)
}
