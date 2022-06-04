object ThirdPartyLibs {
    private const val material = "com.google.android.material:material:${Versions.materialDesign}"
    private const val gson = "com.google.code.gson:gson:${Versions.gson}"
    private const val gsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    val implementations = listOf(material, gson, gsonConverter, glide)
}