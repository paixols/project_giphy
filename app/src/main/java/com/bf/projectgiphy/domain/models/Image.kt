package com.bf.projectgiphy.domain.models

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("original")
    val original: ImageAttributes,
    @SerializedName("downsized")
    val downsized: ImageAttributes
)