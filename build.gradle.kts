import java.util.*

plugins {
    kotlin("multiplatform") apply true
    kotlin("android") apply false
}

kotlin {
    jvm()
}

tasks.register("fetchClasspath") {
    val visited = hashSetOf<ResolvedComponentResult>()
    val cp = project.buildscript.configurations[ScriptHandler.CLASSPATH_CONFIGURATION]
    dependsOn(cp)
    val logger = project.logger
    doLast {
        var current = cp.incoming.resolutionResult.root.also { visited += it }.dependencies

        logger.quiet("report: ")
        val queue = LinkedList<Set<DependencyResult>>()
        while (true) {
            for (dependency in current) {
                with((dependency as? ResolvedDependencyResult)?.selected?.takeIf(visited::add) ?: continue) {
                    logger.quiet("+${'$'}id")
                    queue.add(dependencies)
                }
            }
            if (queue.isEmpty()) break
            current = queue.poll()
        }
    }
}



println("Android: " + runCatching { Class.forName("com.android.build.api.AndroidPluginVersion") }.isSuccess)
println("Kotlin: " + runCatching { Class.forName("org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension") }.isSuccess)