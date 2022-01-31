tasks.register<Zip>("pleaseNotConfigure") {
    error("OH OH! It did configure :(")
}.configure {
    error("OH NO! WHY IS THIS ANY DIFFERNET? WHY IS THIS EXECUTED SECOND?!")
}

println(tasks.withType<Zip>().all {})
