package cl.ravenhill.functors

object PairFunctor {
    fun <A, B, C> Pair<A, B>.map(f: (B) -> C) = Pair(this.first, f(this.second))
}

fun main() {
    val pair: Pair<Int, String> = Pair(420, "functor")
    val identity = with(PairFunctor) {
        pair.map { it }
    }
    println("Functor adheres to the identity law: ${identity == pair}")
    val composition = with(PairFunctor) {
        pair.map { it.length }.map { it * 2 }
    }
    val composed = with(PairFunctor) {
        pair.map { it.length * 2 }
    }
    println("Functor adheres to the composition law: ${composition == composed}")
}
