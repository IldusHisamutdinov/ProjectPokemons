package ru.geekbrains.githubclient.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.githubclient.mvp.model.entity.GithubUser

interface IGithubUsersRepo {
    fun getUsers(): Single<GithubUser>
}