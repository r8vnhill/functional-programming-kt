package cl.ravenhill.lambdas.destructuring

val sumPair = { (a, b): Pair<Int, Int> -> a + b }

val increasePairBy = { (a, b): Pair<Int, Int>, n: Int ->
    (a + n) to (b + n)
}
