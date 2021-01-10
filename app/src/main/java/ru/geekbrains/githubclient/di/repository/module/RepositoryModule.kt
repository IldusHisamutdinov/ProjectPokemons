package ru.geekbrains.githubclient.di.repository.module

import dagger.Module
import dagger.Provides
import ru.geekbrains.githubclient.di.repository.RepositoryScope
import ru.geekbrains.githubclient.mvp.model.api.IDataSource
import ru.geekbrains.githubclient.mvp.model.cache.IReposUserCache
import ru.geekbrains.githubclient.mvp.model.cache.room.RoomRepositoriesCache
import ru.geekbrains.githubclient.mvp.model.entity.room.GithubDatabase
import ru.geekbrains.githubclient.mvp.model.network.INetworkStatus
import ru.geekbrains.githubclient.mvp.model.repo.IGithubRepositoriesRepo
import ru.geekbrains.githubclient.mvp.model.repo.retrofit.RetrofitGithubRepositoriesRepo

@Module
class RepositoryModule {

    @Provides
    fun repoCache(database: GithubDatabase): IReposUserCache = RoomRepositoriesCache(database)

    @RepositoryScope
    @Provides
    fun usersRepositories(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IReposUserCache
    ): IGithubRepositoriesRepo = RetrofitGithubRepositoriesRepo(api, networkStatus, cache)
}