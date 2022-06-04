package com.bf.projectgiphy.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("load_image")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view)
            .load(url)
            .into(view)
    }
}