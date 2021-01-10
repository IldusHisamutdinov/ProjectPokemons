package ru.geekbrains.githubclient.mvp.model.repo

import dagger.Provides
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser

interface IGithubRepositoriesRepo {
    fun getRepositories(url: String): Single<ReposGithubUser>
}
