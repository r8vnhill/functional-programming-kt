import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupOptionModule") {
    description = "Creates the base module and files for the option lesson"
    module.set("option")

    doLast {
        createFiles(
            "option",
            main to "Option.kt",
            main to "OptionMonad.kt",
            test to "OptionMonadTest.kt",
        )
    }
}
