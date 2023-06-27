group = "org.jetbrains.sample"
version = "1.0.0"


val api by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
    attributes { attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_API)) }
}

val apiElements by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = false
    attributes { attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_API)) }
    extendsFrom(api)
}

dependencies {
    /**
     * IMPORTANT NOTE:
     * The dependency here has the same coordinates as ':consumer', but
     * uses a higher version number.
     */
    api("org.jetbrains.sample:consumer:1.0.0")
}