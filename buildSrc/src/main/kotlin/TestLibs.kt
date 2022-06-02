object TestLibs {
    //Testing
    private const val junit5 = "org.junit.jupiter:junit-jupiter-api:${Versions.jupiter}"
    private const val engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.jupiter}"
    private const val mockk = "io.mockk:mockk:${Versions.mockk}"

    //Instrumented Testing
    private const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    private const val testCore = "de.mannodermaus.junit5:android-test-core:${Versions.testCore}"
    private const val junit5TestRunner =
        "de.mannodermaus.junit5:android-test-runner:${Versions.testCore}"

    //UI Testing
    private const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidEspresso}"

    val testImplementations = listOf(junit5, testRunner, testCore, mockk)
    val androidTestRuntimeOnly = listOf(engine, junit5TestRunner)
    val androidTestImplementations = listOf(espresso)
}