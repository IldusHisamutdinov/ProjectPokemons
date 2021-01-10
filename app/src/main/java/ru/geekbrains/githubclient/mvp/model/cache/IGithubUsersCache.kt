package ru.geekbrains.githubclient.mvp.model.cache

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.githubclient.mvp.model.entity.GithubUser
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser

interface IGithubUsersCache {
    fun getUsers(): Single<List<ReposGithubUser>>
    fun addUsers(users: List<ReposGithubUser>): Single<List<ReposGithubUser>>

}