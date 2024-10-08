package cl.ravenhill.kinds

data class PairKind<out A, out B>(val first: A, val second: B) : Kind<PairKind.Of, B> {
    object Of
}
