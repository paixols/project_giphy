object AndroidXLibs {
    private const val core = "androidx.core:core-ktx:${Versions.androidCore}"
    private const val appCompat = "androidx.appcompat:appcompat:${Versions.androidAppCompat}"
    private const val fragment = "androidx.fragment:fragment-ktx:${Versions.androidFragment}"
    private const val preference =
        "androidx.preference:preference-ktx:${Versions.androidPreference}"
    private const val livedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidLifeCycle}"
    private const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidLifeCycle}"
    private const val navRuntime =
        "androidx.navigation:navigation-runtime-ktx:${Versions.androidNavigation}"
    private const val navFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.androidNavigation}"
    private const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.androidNavigation}"
    private const val navModule =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.androidNavigation}"
    private const val navTesting =
        "androidx.navigation:navigation-testing:${Versions.androidNavigation}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.androidConstraintLayout}"
    private const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    val implementations = listOf(
        core,
        appCompat,
        fragment,
        preference,
        livedata,
        viewModel,
        navRuntime,
        navFragment,
        navUi,
        navModule,
        constraintLayout,
        coroutines
    )
}