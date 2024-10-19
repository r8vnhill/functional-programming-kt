val baseName = "functors"
val baseFile = rootProject.file(baseName)

tasks.register("setupFunctionFunctorModule") {
    doLast {
        val main = "main"
        val test = "test"
        val function = "function"
        createFiles(
            function, test to "FunctionFunctorTest.kt",
            main to "FunctionFunctor.kt"
        )
    }
}

fun createFiles(packageName: String, vararg files: Pair<String, String>) {
    val group = rootProject.group.toString().replace(".", "/")
    files.forEach { (type, fileName) ->
        baseFile.resolve(
            "src/$type/kotlin/${group.replace(".", "/")}/" +
                    "functors/$packageName"
        )
            .apply { mkdirs() }
            .resolve(fileName).apply {
                if (!exists()) {
                    writeText(
                        "package $group.functors.$packageName\n\n"
                            .replace("/", ".")
                    )
                    println("File created: $this")
                } else {
                    println("File already exists: $this")
                }
            }
    }
}
