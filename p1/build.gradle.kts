val customConfiguration = configurations.create("custom") {
    isCanBeConsumed = true
    isCanBeResolved = false

    attributes {
        attribute(Attribute.of(String::class.java), "klib")
    }
}

tasks.create("compileCustom") {
    val text =  "X"
    val outputFile = buildDir.resolve("myOutput.txt")
    inputs.property("text", text)
    outputs.file(outputFile)

    doFirst {
        buildDir.mkdirs()
        outputFile.writeText(text)
    }

    project.artifacts.add(customConfiguration.name, outputFile) {
        this.builtBy(this@create)
    }
}
