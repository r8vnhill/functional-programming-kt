package cl.ravenhill.trampoline

sealed interface Trampoline<T>

data class Done<T>(val result: T) : Trampoline<T>

data class More<T>(val continuation: () -> Trampoline<T>) : Trampoline<T>

fun <T> runTrampoline(trampoline: Trampoline<T>): T = when (trampoline) {
    is Done -> trampoline.result
    is More -> runTrampoline(trampoline.continuation())
}
