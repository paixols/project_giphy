package com.bf.projectgiphy.data.models

data class DataRequest(
    val query: String,
    val limit: Int,
    val offset: Int
)