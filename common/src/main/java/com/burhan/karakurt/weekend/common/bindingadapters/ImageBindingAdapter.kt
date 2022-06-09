package com.burhan.karakurt.weekend.common.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    fun setUrl(imageView: ImageView, imageUrl: String?) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}