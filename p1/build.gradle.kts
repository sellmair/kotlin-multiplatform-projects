import org.jetbrains.kotlin.gradle.ib.*
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinUsages


val interopBundle by configurations.creating {

    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, project.usage(KotlinUsages.KOTLIN_API))
    }


    outgoing {
        attributes {
            attribute(commonizerTargetAttribute, interopBundleCommonizerTarget)
        }
    }

    isCanBeResolved = false
    isCanBeConsumed = true
}


tasks.create<Delete>("clean") {
    delete(buildDir)
}
dependencies {
    artifactTypes.register(interopBundleArtifactType) {
        attributes.attribute(commonizerTargetAttribute, interopBundleCommonizerTarget)
    }
    artifactTypes.register(commonizedInteropBundleArtifactType) {
        attributes.attribute(commonizerTargetAttribute, wildcardCommonizerTarget)
    }
}
artifacts {
    add(interopBundle.name, file("libs")) {
        type = interopBundleArtifactType
    }
}
