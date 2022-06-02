package com.bf.projectgiphy.domain.models

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val images: List<Image>
)