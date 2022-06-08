package com.burhan.karakurt.weekend.common.bindingadapters

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindingAdapters {
    @JvmStatic
    @BindingAdapter("android:isVisible")
    fun View.isVisible(isVisible: Boolean?) {
        if (isVisible == null) {
            return
        } else {
            visibility = if (isVisible == true) View.VISIBLE else View.GONE
        }
    }
}