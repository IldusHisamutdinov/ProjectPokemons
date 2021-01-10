package ru.geekbrains.githubclient.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface ReposLoginView : MvpView {
    fun init(pokemon: ReposGithubUser)
    fun loadImage(url:String)
    fun showError(e: Throwable)
    fun release()
}