import org.jetbrains.kotlin.gradle.ib.CommonizerUsages
import org.jetbrains.kotlin.gradle.ib.usage
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinUsages


val commonizerTarget = Attribute.of("commonizerTarget", String::class.java)

val interopBundle by configurations.creating {

    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_API))
    }

    outgoing {
        attributes {
            attribute(Usage.USAGE_ATTRIBUTE, project.usage(CommonizerUsages.interopBundle))
            attribute(KotlinPlatformType.attribute, KotlinPlatformType.native)
            attribute(KotlinNativeTarget.konanTargetAttribute, "commonizer")
            attribute(commonizerTarget, "*")
        }
    }

    isCanBeResolved = false
    isCanBeConsumed = true
}


val createInteropBundleJar by tasks.register<Jar>("createInteropBundle") {
    from(file("libs"))
    this.destinationDirectory.fileValue(buildDir)
    this.archiveFileName.set("interop-bundle.jar")
}

tasks.create<Delete>("clean") {
    delete(buildDir)
}

artifacts {
    add(interopBundle.name, file("libs"))
}
