package com.bf.projectgiphy.domain.models

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("status")
    val status: Int,
    @SerializedName("msg")
    val message: String,
    @SerializedName("response_id")
    val responseId: String
)