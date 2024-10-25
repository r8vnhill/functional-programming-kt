import tasks.SubmoduleSetupTask

tasks.register<SubmoduleSetupTask>("setupOptionModule") {
    description = "Creates the base module and files for the option lesson"
    module.set("option")
}
