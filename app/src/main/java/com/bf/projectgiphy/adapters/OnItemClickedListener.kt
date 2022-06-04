package com.bf.projectgiphy.adapters

import com.bf.projectgiphy.domain.models.Gif

interface OnItemClickedListener {
    fun onItemClicked(item: Gif)
}