package com.burhan.karakurt.weekend.common.bindingadapters

import android.content.res.Resources
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
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

    @JvmStatic
    @BindingAdapter("android:drawableRes")
    fun ImageView.drawableRes(@DrawableRes drawableRes: Int?) {
        if ((drawableRes != null) and (drawableRes != Resources.ID_NULL)) {
            setImageDrawable(drawableRes?.let { ContextCompat.getDrawable(context, it) })
        }
    }
}