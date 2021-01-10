package ru.geekbrains.githubclient.di.user.module

import dagger.Module
import dagger.Provides
import ru.geekbrains.githubclient.di.user.UsersScope
import ru.geekbrains.githubclient.mvp.model.api.IDataSource
import ru.geekbrains.githubclient.mvp.model.cache.IGithubUsersCache
import ru.geekbrains.githubclient.mvp.model.cache.room.RoomGithubUsersCache
import ru.geekbrains.githubclient.mvp.model.entity.room.GithubDatabase
import ru.geekbrains.githubclient.mvp.model.network.INetworkStatus
import ru.geekbrains.githubclient.mvp.model.repo.IGithubUsersRepo
import ru.geekbrains.githubclient.mvp.model.repo.retrofit.RetrofitGithubUsersRepo

@Module
class UsersModule {

    @Provides
    fun usersCache(database: GithubDatabase): IGithubUsersCache = RoomGithubUsersCache(database)

    @UsersScope
    @Provides
    fun usersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IGithubUsersCache
    ): IGithubUsersRepo = RetrofitGithubUsersRepo(api, networkStatus, cache)

}