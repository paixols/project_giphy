package com.bf.projectgiphy.domain.models

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val data: List<Gif>
)