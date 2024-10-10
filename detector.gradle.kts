
gradle.lifecycle.beforeProject {
    tasks.register("checkAndroid") {
        val baseExtensionClass = runCatching { project.buildscript.classLoader.loadClass("com.android.build.gradle.BaseExtension") }.getOrNull()
        val androidExtension = project.extensions.findByName("android")
        val isAndroid = baseExtensionClass?.isInstance(androidExtension) ?: false

        if (project.path == ":") {
            dependsOn(gradle.includedBuilds.map { it.task(":checkAndroid") })
        }

        doLast {
            println("android: $isAndroid")
        }
    }
}

gradle.lifecycle.afterProject {
    val parent = parent ?: return@afterProject
    parent.tasks.named("checkAndroid") {
        dependsOn(tasks.named("checkAndroid"))
    }
}