package ru.geekbrains.githubclient.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UsersView : MvpView {
    fun init()
    fun updateList()
    fun snowError(error:Throwable)
    fun release()
}