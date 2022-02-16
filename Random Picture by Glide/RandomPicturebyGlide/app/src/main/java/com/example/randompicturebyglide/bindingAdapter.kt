package com.example.randompicturebyglide

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view:ImageView,url:String) {
    Glide
        .with(view.context)
        .load(url + System.currentTimeMillis())
        .placeholder(R.drawable.loading_animation)
        .into(view)
}