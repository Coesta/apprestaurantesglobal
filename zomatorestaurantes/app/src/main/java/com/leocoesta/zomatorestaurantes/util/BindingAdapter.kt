package com.leocoesta.zomatorestaurantes.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.leocoesta.zomatorestaurantes.R

@BindingAdapter("ImageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        var imgUri = it.toUri().buildUpon().scheme("https").build()

        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_cloud_download)
                    .error(R.drawable.ic_error)
            )
            .into(imgView)
    }

}