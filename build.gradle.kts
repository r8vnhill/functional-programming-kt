plugins {
    id("jvm.conventions")
    alias(libs.plugins.detekt)
}

val projectGroup = extra["functional-programming.group"]!! // Throws an exception if the property is not found
val projectVersion: String = libs.versions.functional.programming.get()
val detektId: String = libs.plugins.detekt.get().pluginId
val detektFormattingModule = libs.detekt.formatting.get().module.toString()
val detektFormattingVersion = libs.detekt.formatting.get().version

allprojects {
    group = projectGroup
    version = projectVersion
}

val kotest = libs.kotest

subprojects {
    apply(plugin = "jvm.conventions")
    apply(plugin = detektId)

    dependencies {
        detektPlugins("$detektFormattingModule:$detektFormattingVersion")
        testImplementation(kotest)
    }
}
