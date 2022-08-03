object Issue {

    val libraryApiV1 = libraryApi
    val libraryApiV2 = libraryApiV1 as LibraryApi

    init {
        libraryApiV1.availableInVersion1()
        libraryApiV1.availableInversion2()

        libraryApiV2.availableInVersion1()
        libraryApiV2.availableInversion2()
    }
}

