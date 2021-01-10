package ru.geekbrains.githubclient.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url
import ru.geekbrains.githubclient.mvp.model.entity.GithubUser
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser

interface IDataSource {

    @GET("master/pokedex.json")
    fun loadUsers(): Single<GithubUser>

    @GET
    fun getRepositories(@Url url: String): Single<ReposGithubUser>

}


