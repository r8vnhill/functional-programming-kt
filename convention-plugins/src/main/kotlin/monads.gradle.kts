import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupMonadsModule") {
    description = "Creates the base module and files for the monads lesson"
    module.set("monads")

    doLast {
        createFiles(
            "monads",
            main to "Box.kt",
            main to "BoxMonad.kt",
            test to "BoxMonadTest.kt",
        )
    }
}
