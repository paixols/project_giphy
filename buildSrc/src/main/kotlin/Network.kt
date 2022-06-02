object Network {
    private const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    private const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    private const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"

    val implementations = listOf(retrofit2, loggingInterceptor, okhttp3)
}