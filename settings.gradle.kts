rootProject.name = "functional-programming-kt"

pluginManagement {
    includeBuild("convention-plugins")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

include(
    ":adt",
    ":lambdas",
    ":hof",
    ":functors",
)
include("monads")
include("monads:option")