package ru.geekbrains.githubclient.mvp.model.cache

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser

interface IReposUserCache {
    fun addReposUser(listRepos:List<Pokemon>): Single<List<Pokemon>>
    fun getReposUser(): Single<List<Pokemon>> // fun getAllPokemon():Single<List<Pokemon>>

}