import tasks.ModuleSetupTask

tasks.register<ModuleSetupTask>("setupHofModule") {
    description = "Creates the base module and files for the higher-order functions lesson"
    module.set("hof")
    doLast {
        createFiles(
            "functional.map",
            main to "Map.kt",
            test to "MapTest.kt"
        )
        createFiles(
            "functional.filter",
            main to "Filter.kt"
        )
        createFiles(
            "functional.fold",
            main to "Fold.kt",
            test to "FoldTest.kt"
        )
    }
}
