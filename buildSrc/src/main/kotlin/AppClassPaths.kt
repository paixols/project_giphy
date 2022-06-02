object AppClassPaths {
    private const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    private const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    private const val navArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    private const val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5}"

    val classPaths = listOf(gradle, kotlin, navArgs, junit5)
}