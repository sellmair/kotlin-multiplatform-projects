import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

operator fun KotlinSourceSet.invoke(builder: SourceSetHierarchyBuilder.() -> Unit): KotlinSourceSet {
    SourceSetHierarchyBuilder(this).builder()
    return this
}

class SourceSetHierarchyBuilder(private val node: KotlinSourceSet) {
    operator fun KotlinSourceSet.unaryMinus() = this.dependsOn(node)
}

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

publishing {
    repositories {
        this.maven {
            this.name = "build"
            this.url = buildDir.resolve("repo").toURI()
        }
    }
}



kotlin {
    ios {
        compilations.getByName("main").cinterops.create("StarIO")
        binaries.framework {
            this.embedBitcode(org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode.DISABLE)
        }
    }
}
