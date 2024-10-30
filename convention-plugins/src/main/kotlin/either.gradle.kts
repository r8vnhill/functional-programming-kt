import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupEitherModule") {
    description = "Creates the base module and files for the either lesson"
    module.set("monads:either")

    doLast {
        createFiles(
            "either",
            main to "Either.kt",
            main to "EitherMonad.kt",
            main to "validatePassword.kt",
            test to "EitherMonadTest.kt"
        )
    }
}
