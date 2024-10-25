package cl.ravenhill.option

sealed interface Option<out A>

data class Some<out A>(val value: A) : Option<A>

data object None : Option<Nothing>
