package cl.ravenhill.password

import cl.ravenhill.either.EitherMonad
import cl.ravenhill.either.Left
import cl.ravenhill.either.Right

private fun validateLength(password: String) =
    if (password.length >= 8) Right(password)
    else Left("Password is too short")

private fun validateContainsNumber(password: String) =
    if (password.any { it.isDigit() }) Right(password)
    else Left("Password must contain a number")

fun validatePassword(password: String) = with(EitherMonad) {
    pure<String, _>(password)
        .flatMap(::validateLength)
        .flatMap(::validateContainsNumber)
}

fun main() {
    println(validatePassword("1234567"))
    println(validatePassword("12345678"))
    /* Output:
    Left(value=Password is too short)
    Right(value=12345678)
    */
}
