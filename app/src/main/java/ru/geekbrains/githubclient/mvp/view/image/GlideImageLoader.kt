package ru.geekbrains.githubclient.mvp.view.image

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader:IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
                .load(url)
                .into(container)
    }

}