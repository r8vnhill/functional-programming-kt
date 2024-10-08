package cl.ravenhill.monads

object BoxMonad {
    fun <A> pure(a: A): Box<A> = Box(a)
    fun <A, B> Box<A>.flatMap(f: (A) -> Box<B>): Box<B> = f(value)
}

fun main() {
    val box: Box<Int> = Box(420)
    val leftIdentity = with(BoxMonad) {
        pure(420).flatMap { Box(it) }
    }
    println("Monad adheres to the left identity law: ${leftIdentity == box}")
    val rightIdentity = with(BoxMonad) {
        box.flatMap { pure(it) }
    }
    println("Monad adheres to the right identity law: ${rightIdentity == box}")
    val composition = with(BoxMonad) {
        box.flatMap { Box(it + 1) }.flatMap { Box(it * 2) }
    }
    val composed = with(BoxMonad) {
        box.flatMap { Box((it + 1) * 2) }
    }
    println("Monad adheres to the composition law: ${composition == composed}")

}
