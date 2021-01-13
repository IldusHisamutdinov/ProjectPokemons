package ru.geekbrains.githubclient.mvp.view.list

import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser

interface LoginItemView: IItemView {
    fun setName(text: String)
    fun bind(pokemon: ReposGithubUser)
    fun loadAvatar(url: String)
    fun id(text: String)
}