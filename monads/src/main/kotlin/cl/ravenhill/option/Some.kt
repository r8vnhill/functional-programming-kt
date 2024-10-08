package cl.ravenhill.option

data class Some<out T>(val value: T) : Option<T>()
