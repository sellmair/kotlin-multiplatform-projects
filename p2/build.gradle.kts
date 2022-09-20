val implementation = configurations.create("implementation") {
    isCanBeConsumed = false
    isCanBeResolved = true
    attributes {
        attribute(Attribute.of(String::class.java), "klib")
    }
}

dependencies {
    implementation(project(":p1"))
}

tasks.create("consume") {
    inputs.files(implementation)
    outputs.files("ghost.txt")
    doFirst {
        println("Resolved: " + implementation.files.single().readText())
    }
}