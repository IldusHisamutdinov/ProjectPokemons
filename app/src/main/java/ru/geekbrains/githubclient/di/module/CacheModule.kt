package ru.geekbrains.githubclient.di.module


import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.geekbrains.githubclient.GithubApplication

import ru.geekbrains.githubclient.mvp.model.entity.room.GithubDatabase
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(): GithubDatabase = Room.databaseBuilder(
                GithubApplication.instance,
                GithubDatabase::class.java,
                GithubDatabase.DB_NAME)
                .build()
}