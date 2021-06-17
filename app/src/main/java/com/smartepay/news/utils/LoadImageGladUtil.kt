package com.smartepay.news.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.smartepay.news.R

object  LoadImageGladUtil {




    @BindingAdapter("android:loadImage")
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String?) {
        val context = imageView.context
        Glide.with(context).load(url)
            .transform( CenterCrop(), RoundedCorners(5))
            .placeholder(R.drawable.loading_img).into(imageView)
    }

}