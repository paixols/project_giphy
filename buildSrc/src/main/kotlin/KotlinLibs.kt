object KotlinLibs {
    private const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    private const val kotlin_coroutines_extension =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktx_coroutines}"

    val implementations = listOf(
        kotlin,
        kotlin_coroutines_extension
    )
}