package cl.ravenhill.functors

object BoxFunctor {
    fun <A, B> Box<A>.map(f: (A) -> B) = Box(f(this.value))
}

fun main() {
    val box: Box<Int> = Box(420)
    val identity = with(BoxFunctor) {
        box.map { it }
    }
    println("Functor adheres to the identity law: ${identity == box}")
    val composition = with(BoxFunctor) {
        box.map { it + 1 }.map { it * 2 }
    }
    val composed = with(BoxFunctor) {
        box.map { (it + 1) * 2 }
    }
    println("Functor adheres to the composition law: ${composition == composed}")
}
