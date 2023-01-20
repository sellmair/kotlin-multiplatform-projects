import okio.Path

object ConsumerACommon {
    val useOkioFromCompositeBuildAsTransitiveDependency: Path = ProducerACommon.useOkio()
    //val useMviKotlinShouldNotResolveAsImplementationDependency = ProducerACommon.useMviKotlin()
}