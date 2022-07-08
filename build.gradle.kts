allprojects {
    repositories {
        mavenLocal()
        maven("https://cache-redirector.jetbrains.com/repo.maven.apache.org/maven2/")
        maven("https://cache-redirector.jetbrains.com/dl.google.com.android.maven2/")
        maven("https://cache-redirector.jetbrains.com/plugins.gradle.org/m2/")
        maven("https://cache-redirector.jetbrains.com/maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
}
