package ru.geekbrains.githubclient.di.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.geekbrains.githubclient.mvp.view.image.GlideImageLoader
import ru.geekbrains.githubclient.mvp.view.image.IImageLoader
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()

}