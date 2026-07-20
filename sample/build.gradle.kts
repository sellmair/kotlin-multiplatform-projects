plugins {
    kotlin("jvm")
}

tasks.test.configure {
    failOnNoDiscoveredTests = true
    filter.isFailOnNoMatchingTests = true

    /*
    Just providing any pattern for excludes will actually trigger the failure;
    Uncomment the line below to see the build failing
     */
    //filter.excludeTestsMatching("~never matched~")

    useJUnitPlatform {
        excludeTags("myTag")
    }
}

dependencies {
    testImplementation(kotlin("test-junit5"))
}