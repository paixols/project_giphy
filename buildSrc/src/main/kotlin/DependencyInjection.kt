object DependencyInjection {
    private const val dagger2 = "com.google.dagger:dagger:${Versions.dagger2}"
    private const val dagger2Kapt = "com.google.dagger:dagger-compiler:${Versions.dagger2}"

    val implementations = listOf(dagger2)
    val kaptImplementations = listOf(dagger2Kapt)
}