package cl.ravenhill.lambdas

fun processInts(a: Int, b: Int, operation: (Int, Int) -> Int) =
    operation(a, b)
